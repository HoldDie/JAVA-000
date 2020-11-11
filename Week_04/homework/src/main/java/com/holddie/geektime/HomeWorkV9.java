package com.holddie.geektime;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class HomeWorkV9 extends AbstractHomeWork {

	private static volatile boolean isOver = false;

	@Override
	public int asyncMethod() {
		CyclicBarrier cyclicBarrier = new CyclicBarrier(1, () -> {
			isOver = true;
		});
		AtomicInteger sum = new AtomicInteger();
		Thread thread = new Thread(() -> {
			try {
				sum.set(sum());
				cyclicBarrier.await();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		thread.start();
		while (true) {
			if (!isOver) {
				continue;
			}
			break;
		}
		return sum.get();
	}


	public static void main(String[] args) {
		HomeWorkV9 homeWorkV1 = new HomeWorkV9();
		homeWorkV1.sequentialExecute();
	}

}
