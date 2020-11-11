package com.holddie.geektime;

import java.util.concurrent.*;

public class HomeWorkV14 extends AbstractHomeWork {
	@Override
	public int asyncMethod() {
		Callable<Integer> callable = new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				return sum();
			}
		};
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		Future<Integer> submit = executorService.submit(callable);
		Integer sum = 0;
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
		HomeWorkV14 homeWorkV1 = new HomeWorkV14();
		homeWorkV1.sequentialExecute();
	}

}
