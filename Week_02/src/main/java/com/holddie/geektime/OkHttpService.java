package com.holddie.geektime;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class OkHttpService {
	
	public void requestGet() {
		String url = " http://localhost:8801";
		OkHttpClient okHttpClient = new OkHttpClient();
		final Request request = new Request.Builder()
				.url(url)
				.build();
		final Call call = okHttpClient.newCall(request);
		new Thread(() -> {
			try {
				Response response = call.execute();
				System.out.println("run: " + response.body());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}).start();
	}

	public static void main(String[] args) {
		
	}
}
