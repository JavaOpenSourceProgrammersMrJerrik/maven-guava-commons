package com.mangocity.guava.cache;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;

/**
 * 测试本地缓存,统计缓存命中率
 * @author mbr.yangjie
 */
public class CodeOfMyself {
	private static class Mbr {
		private Long id;
		private String name;
		private String desc;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDesc() {
			return desc;
		}

		public void setDesc(String desc) {
			this.desc = desc;
		}

		@Override
		public String toString() {
			return "Mbr [id=" + id + ", name=" + name + ", desc=" + desc + "]";
		}

	}

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		final Random random = new Random();
		LoadingCache<Long, Mbr> cacheBuilder = CacheBuilder.newBuilder()
				.expireAfterWrite(8, TimeUnit.SECONDS)//// 设置写缓存后8秒钟过期
				.expireAfterAccess(10, TimeUnit.SECONDS).maximumSize(100)//无效
				.concurrencyLevel(8)// 设置并发级别为8，并发级别是指可以同时写缓存的线程数
				.initialCapacity(20)
				.recordStats()
				.removalListener(new RemovalListener<Long, Mbr>() {

					@Override
					public void onRemoval(
							RemovalNotification<Long, Mbr> notification) {
						System.out.println("onRemoval start...cause: "
								+ notification.getCause() + " ,key: "
								+ notification.getKey() + " ,value: "
								+ notification.getValue());
					}
				}).build(new CacheLoader<Long, Mbr>() {
					@Override
					public Mbr load(Long key) throws Exception {
						TimeUnit.SECONDS.sleep(5);
						System.out.println("缓存没命中...key: " + key);
						Mbr mbr = new Mbr();
						mbr.setId(random.nextLong());
						mbr.setName("builderMbrName_" + random.nextInt(100));
						mbr.setDesc("load");
						return mbr;
					}
				});
		
		for(int i=0;i<20;i++){
			Mbr mbr = cacheBuilder.get(200L);
			//cacheBuilder.invalidate(200L); 过期某个key
			System.out.println("cacheBuilder.get(200L): " + mbr);
			TimeUnit.SECONDS.sleep(1);
		}
		
		System.out.println("缓存命中率情况: " + cacheBuilder.stats());
	}
}
