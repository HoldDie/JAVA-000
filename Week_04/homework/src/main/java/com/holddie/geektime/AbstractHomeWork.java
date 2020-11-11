package com.holddie.geektime;

public abstract class AbstractHomeWork {

	private long startTime;

	private void before() {
		startTime = System.currentTimeMillis();
		System.out.println("开始执行主线程");
	}

	public abstract int asyncMethod() throws InterruptedException;

	private void after() {
		System.out.println("结束主线程执行");
		System.out.println("使用时间：" + (System.currentTimeMillis() - startTime) + " ms");
	}

	protected void sequentialExecute() {
		before();
		System.out.println("开始调用异步方法");
		try {
			System.out.println("执行异步线程计算结果是：" + asyncMethod());
		} catch (InterruptedException e) {
			System.out.println("调用异步方法异常");
			e.printStackTrace();
		}
		System.out.println("调用异步方法结束");
		after();
	}

	protected int sum() {
		System.out.println("开始调用 Sum 方法");
		int fibo = fibo(36);
		System.out.println("调用返回 Sum 方法值为：" + fibo);
		return fibo;
	}

	private int fibo(int value) {
		if (value < 2) {
			return 1;
		}
		int i = 1, j = 1;
		while (value-- > 1) {
			int sum = i + j;
			j = i;
			i = sum;
		}
		return i;
	}
}
