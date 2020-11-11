package com.holddie.geektime;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class HomeWorkV6 extends AbstractHomeWork {
	@Override
	public int asyncMethod() throws InterruptedException {
		CountDownLatch countDownLatch = new CountDownLatch(1);
		AtomicInteger sum = new AtomicInteger();
		Thread thread = new Thread(() -> {
			try {
				sum.set(sum());
			} catch (Exception ignored) {
			} finally {
				countDownLatch.countDown();
			}
		});
		thread.start();
		countDownLatch.await();
		return sum.get();
	}


	public static void main(String[] args) {
		HomeWorkV6 homeWorkV1 = new HomeWorkV6();
		homeWorkV1.sequentialExecute();
	}

}
