package com.holddie.geektime;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer02 {
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(8802);
		while (true) {
			Socket socket = serverSocket.accept();
			new Thread(() -> {
				try {
					service(socket);
				} catch (InterruptedException | IOException e) {
					e.printStackTrace();
				}
			}).start();
		}
	}

	private static void service(Socket socket) throws InterruptedException, IOException {
		Thread.sleep(20);
		PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
		printWriter.println("HTTP/1.1 200 OK");
		printWriter.println("Content-Type:text/html;charset=utf-8");
		String body = "hello,nio - 02";
		printWriter.println("Content-Length:" + body.getBytes().length);
		printWriter.println();
		printWriter.write(body);
		printWriter.close();
		socket.close();
	}
}
