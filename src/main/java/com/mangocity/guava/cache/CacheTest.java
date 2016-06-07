package com.mangocity.guava.cache;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;

public class CacheTest {

	@Test
	public void testCacheLoader() throws Exception {
		LoadingCache<String, String> cahceBuilder = CacheBuilder.newBuilder()
				.build(new CacheLoader<String, String>() {
					@Override
					public String load(String key) throws Exception {
						String strProValue = "hello " + key + "!";
						return strProValue;
					}

				});

		System.out.println("jerry value:" + cahceBuilder.get("jerry"));
		System.out.println("peida value:" + cahceBuilder.get("peida"));
		cahceBuilder.put("harry", "ssdded");
		System.out.println("harry value:" + cahceBuilder.get("harry"));
	}

	@Test
	public void testCallableCache() throws Exception {
		Cache<String, String> cache = CacheBuilder.newBuilder()
				.maximumSize(1000).build();
		String resultVal = cache.get("jerry", new Callable<String>() {
			public String call() {
				String strProValue = "hello " + "jerry" + "!";
				return strProValue;
			}
		});
		System.out.println("jerry value : " + resultVal);
		cache.put("peida", "panda....");
		resultVal = cache.get("peida", new Callable<String>() {
			public String call() {
				String strProValue = "hello " + "peida" + "!";
				return strProValue;
			}
		});
		System.out.println("peida value : " + resultVal);
	}

	/**
	 * 不需要延迟处理(泛型的方式封装)
	 * 
	 * @return
	 */
	public <K, V> LoadingCache<K, V> cached(CacheLoader<K, V> cacheLoader) {
		LoadingCache<K, V> cache = CacheBuilder.newBuilder().maximumSize(2)
				.weakKeys().softValues()
				.refreshAfterWrite(120, TimeUnit.SECONDS)
				.expireAfterWrite(10, TimeUnit.MINUTES)
				.removalListener(new RemovalListener<K, V>() {
					@Override
					public void onRemoval(RemovalNotification<K, V> rn) {
						System.out.println(rn.getKey() + "被移除");

					}
				}).build(cacheLoader);
		return cache;
	}

	/**
	 * 通过key获取value 调用方式 commonCache.get(key) ; return String
	 * 
	 * @param key
	 * @return
	 * @throws Exception
	 */

	public LoadingCache<String, String> commonCache(final String key)
			throws Exception {
		LoadingCache<String, String> commonCache = cached(new CacheLoader<String, String>() {
			@Override
			public String load(String key) throws Exception {
				return "hello " + key + "!";
			}
		});
		return commonCache;
	}

	@Test
	public void testCache() throws Exception {
		LoadingCache<String, String> commonCache = commonCache("peida");
		System.out.println("peida:" + commonCache.get("peida"));
		System.out.println("harry:" + commonCache.get("harry"));
		System.out.println("lisa:" + commonCache.get("lisa"));
	}
}
