package com.mangocity.guava.cache;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

/**
 * 限流
 * 
 * @author mbr.yangjie
 *
 */
public class LimitFlow {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		LoadingCache<Long, AtomicLong> counter = CacheBuilder.newBuilder()
				.expireAfterWrite(2, TimeUnit.SECONDS)
				.build(new CacheLoader<Long, AtomicLong>() {
					@Override
					public AtomicLong load(Long seconds) throws Exception {
						System.out.println("load data...");
						return new AtomicLong(0);
					}
				});
		long limit = 1000;
		while (true) {
			// 得到当前秒
			long currentSeconds = System.currentTimeMillis() / 1000;
			if (counter.get(currentSeconds).incrementAndGet() > limit) {
				System.out.println(counter.get(currentSeconds) + " ,limit flow...:" + currentSeconds);
				continue;
			}
			// 业务处理
		}
	}
}
