package com.holddie.geektime;

import java.util.concurrent.atomic.AtomicInteger;

public class HomeWorkV2 extends AbstractHomeWork {
	@Override
	public int asyncMethod() throws InterruptedException {
		final AtomicInteger sum = new AtomicInteger();
		Thread thread = new Thread(() -> sum.set(sum()));
		thread.start();
		thread.join();
		return sum.get();
	}


	public static void main(String[] args) {
		HomeWorkV2 homeWorkV1 = new HomeWorkV2();
		homeWorkV1.sequentialExecute();
	}

}
