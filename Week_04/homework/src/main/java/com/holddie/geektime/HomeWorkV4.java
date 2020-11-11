package com.holddie.geektime;

import java.util.concurrent.atomic.AtomicInteger;

public class HomeWorkV4 extends AbstractHomeWork {
	@Override
	public int asyncMethod() throws InterruptedException {
		Object mutex = new Object();
		AtomicInteger sum = new AtomicInteger();
		Thread thread = new Thread(() -> {
			synchronized (mutex) {
				sum.set(sum());
				mutex.notify();
			}
		});

		thread.start();
		synchronized (mutex) {
			if (sum.get() == 0) {
				mutex.wait();
			}
			return sum.get();
		}
	}


	public static void main(String[] args) {
		HomeWorkV4 homeWorkV1 = new HomeWorkV4();
		homeWorkV1.sequentialExecute();
	}

}
