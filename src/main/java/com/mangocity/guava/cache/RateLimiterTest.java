package com.mangocity.guava.cache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.google.common.util.concurrent.RateLimiter;

public class RateLimiterTest {

	public static void main(String[] args) {
		final RateLimiter limiter = RateLimiter.create(100);

		ExecutorService executors = Executors.newCachedThreadPool();

		for (int i = 0; i < 80; i++) {
			executors.execute(new Runnable() {
				@Override
				public void run() {
					limitFlow(limiter);
				}

			});
		}
	}

	private  static void limitFlow(final RateLimiter limiter) {
		if (limiter.tryAcquire()) {
			System.out.println("正常输出...");
			try {
				TimeUnit.SECONDS.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("已经限制了请求访问频率");
		}
	}

}
