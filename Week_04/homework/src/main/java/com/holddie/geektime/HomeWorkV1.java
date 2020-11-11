package com.holddie.geektime;

import java.util.concurrent.atomic.AtomicInteger;

public class HomeWorkV1 extends AbstractHomeWork {
	@Override
	public int asyncMethod() throws InterruptedException {
		final AtomicInteger sum = new AtomicInteger();
		Runnable runnable = new Runnable() {
			public void run() {
				sum.set(sum());
			}
		};
		Thread thread = new Thread(runnable);
		thread.start();
		thread.join();
		return sum.get();
	}

	public static void main(String[] args) {
		HomeWorkV1 homeWorkV1 = new HomeWorkV1();
		homeWorkV1.sequentialExecute();
	}

}
