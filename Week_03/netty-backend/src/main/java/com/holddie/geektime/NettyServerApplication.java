package com.holddie.geektime;

public class NettyServerApplication {


	public static void main(String[] args) {
		HttpServer httpServer = new HttpServer(false, 8088);
		try {
			httpServer.run();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
