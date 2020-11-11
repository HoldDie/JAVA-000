package com.holddie.geektime;

import java.util.concurrent.ArrayBlockingQueue;

public class HomeWorkV11 extends AbstractHomeWork {
	@Override
	public int asyncMethod() throws InterruptedException {
		ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(1);
//        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<Integer>(1);
		Thread thread = new Thread(() -> {
			try {
				int sum = sum();
				queue.offer(sum);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		thread.start();
		// 队列为空则阻塞
		return queue.take();
	}


	public static void main(String[] args) {
		HomeWorkV11 homeWorkV1 = new HomeWorkV11();
		homeWorkV1.sequentialExecute();
	}

}
