package com.holddie.geektime;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

public class HomeWorkV7 extends AbstractHomeWork {
	@Override
	public int asyncMethod() {
		CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
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
		try {
			cyclicBarrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
		return sum.get();
	}


	public static void main(String[] args) {
		HomeWorkV7 homeWorkV1 = new HomeWorkV7();
		homeWorkV1.sequentialExecute();
	}

}
