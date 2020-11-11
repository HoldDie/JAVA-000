package com.holddie.geektime;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class HomeWorkV15 extends AbstractHomeWork {
	@Override
	public int asyncMethod() {
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		Future<Integer> submit = executorService.submit(() -> sum());
		Integer sum = null;
		try {
			sum = submit.get();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		executorService.shutdown();

		return sum;
	}


	public static void main(String[] args) {
		HomeWorkV15 homeWorkV1 = new HomeWorkV15();
		homeWorkV1.sequentialExecute();
	}

}
