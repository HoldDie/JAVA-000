package com.holddie.geektime;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class HomeWorkV5 extends AbstractHomeWork {
	@Override
	public int asyncMethod() throws InterruptedException {
		ReentrantLock lock = new ReentrantLock();
		Condition condition = lock.newCondition();
		AtomicInteger sum = new AtomicInteger();
		Thread thread = new Thread(() -> {
			lock.lock();
			try {
				sum.set(sum());
			} finally {
				condition.signal();
				lock.unlock();
			}
		});
		thread.start();
		lock.lock();
		// 防止子线程先执行完，wait后，没人signal
		if (sum.get() == 0) {
			condition.await();
		}
		lock.unlock();
		return sum.get();
	}


	public static void main(String[] args) {
		HomeWorkV5 homeWorkV1 = new HomeWorkV5();
		homeWorkV1.sequentialExecute();
	}

}
