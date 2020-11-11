package com.holddie.geektime;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

public class HomeWorkV13 extends AbstractHomeWork {
	@Override
	public int asyncMethod() {
		try {
			return CompletableFuture.supplyAsync(() -> {
				System.out.println(Thread.currentThread().getName() + "=执行计算=");
				return sum();
			}).get();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		return 0;
	}


	public static void main(String[] args) {
		HomeWorkV13 homeWorkV1 = new HomeWorkV13();
		homeWorkV1.sequentialExecute();
	}

}
