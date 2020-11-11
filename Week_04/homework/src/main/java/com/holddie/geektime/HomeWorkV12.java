package com.holddie.geektime;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class HomeWorkV12 extends AbstractHomeWork {
	@Override
	public int asyncMethod() {
		FutureTask<Integer> futureTask = new FutureTask<Integer>(new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				return sum();
			}
		});
		new Thread(futureTask).start();
		Integer sum = 0;
		try {
			sum = futureTask.get();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		return sum;
	}


	public static void main(String[] args) {
		HomeWorkV12 homeWorkV1 = new HomeWorkV12();
		homeWorkV1.sequentialExecute();
	}

}
