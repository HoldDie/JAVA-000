package com.holddie.geektime;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;

public class CustomizeHttpHandler extends ChannelInboundHandlerAdapter {

	private static Logger logger = LoggerFactory.getLogger(CustomizeHttpHandler.class);

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) {
		ctx.flush();
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) {
		try {
			FullHttpRequest fullHttpRequest = (FullHttpRequest) msg;
			String uri = fullHttpRequest.uri();
			logger.info("接收到的请求 URL 为：{}", uri);
			if (uri.startsWith("/hello/")) {
				handlerRequest(fullHttpRequest, ctx);
			}
		} finally {
			ReferenceCountUtil.release(msg);
		}
	}

	private void handlerRequest(FullHttpRequest fullHttpRequest, ChannelHandlerContext ctx) {
		FullHttpResponse response = null;
		try {
			String body = getBody(fullHttpRequest);
			logger.info("获取到的参数为：{}", body);
			HttpMethod method = fullHttpRequest.method();
			logger.info("获取请求方法：{}", method);
			String name = fullHttpRequest.uri().substring(7);
			String value = "hello," + name;
			logger.info("获取到的 value：{}", value);
			response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, Unpooled.wrappedBuffer(value.getBytes(StandardCharsets.UTF_8)));
			response.headers().set("Content-Type", "application/json");
			response.headers().setInt("content-Length", response.content().readableBytes());
		} catch (Exception e) {
			logger.error("处理测试接口出错", e);
			response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.NO_CONTENT);
		} finally {
			if (fullHttpRequest != null) {
				if (!HttpUtil.isKeepAlive(fullHttpRequest)) {
					ctx.write(response).addListener(ChannelFutureListener.CLOSE);
				} else {
//					response.headers().set(HttpHeaderNames.CONNECTION, HttpHeaderValues.KEEP_ALIVE);
					ctx.write(response);
				}
			}
		}
	}

	private String getBody(FullHttpRequest request) {
		ByteBuf buf = request.content();
		return buf.toString(CharsetUtil.UTF_8);
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.close();
	}
}
