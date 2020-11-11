package com.holddie.geektime;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

public class HomeWorkV8 extends AbstractHomeWork {
	@Override
	public int asyncMethod() {
		Thread currentThread = Thread.currentThread();
		CyclicBarrier cyclicBarrier = new CyclicBarrier(1, () -> {
			// 如果先unpark，后park，也没有关系，
			// 会把下一次park的线程唤醒
			LockSupport.unpark(currentThread);
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
		LockSupport.park();
		return sum.get();
	}


	public static void main(String[] args) {
		HomeWorkV8 homeWorkV1 = new HomeWorkV8();
		homeWorkV1.sequentialExecute();
	}

}
