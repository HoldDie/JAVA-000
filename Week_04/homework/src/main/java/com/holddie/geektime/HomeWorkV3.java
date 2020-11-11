package com.holddie.geektime;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class HomeWorkV3 extends AbstractHomeWork {
	@Override
	public int asyncMethod() throws InterruptedException {
		Object obj = new Object();
		AtomicInteger sum = new AtomicInteger();
		Thread thread = new Thread(() -> {
			synchronized (obj) {
				sum.set(sum());
			}
		});

		thread.start();
		// 故意添加延时，否则执行虽然可以计算出结果，但是执行顺序不对劲
		TimeUnit.SECONDS.sleep(1);
		synchronized (obj) {
			return sum.get();
		}
	}


	public static void main(String[] args) {
		HomeWorkV3 homeWorkV1 = new HomeWorkV3();
		homeWorkV1.sequentialExecute();
	}

}
