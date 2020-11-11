package com.holddie.geektime;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class HomeWorkV10 extends AbstractHomeWork {
	@Override
	public int asyncMethod() throws InterruptedException {
		Semaphore semaphore = new Semaphore(0);
		AtomicInteger sum = new AtomicInteger();
		Thread thread = new Thread(() -> {
			try {
				sum.set(sum());
				semaphore.release();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		thread.start();
		semaphore.acquire();
		return sum.get();
	}


	public static void main(String[] args) {
		HomeWorkV10 homeWorkV1 = new HomeWorkV10();
		homeWorkV1.sequentialExecute();
	}

}
