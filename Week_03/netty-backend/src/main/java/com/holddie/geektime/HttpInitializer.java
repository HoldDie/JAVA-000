package com.holddie.geektime;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.handler.ssl.SslContext;

public class HttpInitializer extends ChannelInitializer<SocketChannel> {

	private final SslContext sslContext;

	public HttpInitializer(SslContext sslContext) {
		this.sslContext = sslContext;
	}

	@Override
	protected void initChannel(SocketChannel socketChannel) {

		ChannelPipeline channelPipeline = socketChannel.pipeline();
		if (sslContext != null) {
			channelPipeline.addLast(sslContext.newHandler(socketChannel.alloc()));
		}
		channelPipeline.addLast(new HttpRequestDecoder());
		channelPipeline.addLast(new HttpResponseEncoder());
		channelPipeline.addLast(new HttpObjectAggregator(1024 * 1024));
		channelPipeline.addLast(new CustomizeHttpHandler());
	}
}
