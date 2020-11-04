package com.holddie.geektime;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newFixedThreadPool;

public class HttpServer03 {
	public static void main(String[] args) throws IOException {
		final ExecutorService executorService = newFixedThreadPool(40);
		final ServerSocket serverSocket = new ServerSocket(8803);
		while (true) {
			final Socket socket = serverSocket.accept();
			executorService.execute(() -> {
				try {
					service(socket);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
		}
	}

	private static void service(Socket socket) throws InterruptedException, IOException {
		Thread.sleep(20);
		PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
		printWriter.println("HTTP/1.1 200 OK");
		printWriter.println("Content-Type:text/html;charset=utf-8");
		String body = "hello,nio - 03";
		printWriter.println("Content-Length:" + body.getBytes().length);
		printWriter.println();
		printWriter.write(body);
		printWriter.close();
		socket.close();
	}
}
