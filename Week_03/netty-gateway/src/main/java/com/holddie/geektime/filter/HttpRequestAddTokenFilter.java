package com.holddie.geektime.filter;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;

public class HttpRequestAddTokenFilter implements HttpRequestFilter {
	@Override
	public void filter(FullHttpRequest fullRequest, ChannelHandlerContext ctx) {
		fullRequest.headers().set("auth-token", "auto add token");
	}
}
