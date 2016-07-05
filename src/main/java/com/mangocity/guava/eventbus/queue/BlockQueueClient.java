package com.mangocity.guava.eventbus.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BlockQueueClient {
	private static class Email{
		private Long emailId;
		
		private String from;
		
		private String to;
		
		private String content;
		
		private String title;
		
		private String subTitle;
		
		
		public Email() {
			super();
			
		}

		public Email(Long emailId, String from, String to, String content, String title, String subTitle) {
			super();
			this.emailId = emailId;
			this.from = from;
			this.to = to;
			this.content = content;
			this.title = title;
			this.subTitle = subTitle;
		}

		public Long getEmailId() {
			return emailId;
		}

		public void setEmailId(Long emailId) {
			this.emailId = emailId;
		}

		public String getFrom() {
			return from;
		}

		public void setFrom(String from) {
			this.from = from;
		}

		public String getTo() {
			return to;
		}

		public void setTo(String to) {
			this.to = to;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getSubTitle() {
			return subTitle;
		}

		public void setSubTitle(String subTitle) {
			this.subTitle = subTitle;
		}
		
	}

	public static void main(String[] args) {
		final BlockingQueue<Email> blockQueue = new ArrayBlockingQueue<Email>(200);
		
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		executor.execute(new Runnable() {
			@Override
			public void run() {
				sendEmail(blockQueue);
			}
		});
		
		executor.execute(new Runnable() {
			@Override
			public void run() {
				extractEmail(blockQueue);
			}
		});
	}
	

	private static void sendEmail(BlockingQueue<Email> blockQueue) {
		try {
			System.out.println("sendEmail begin{}...");
			blockQueue.put(new Email());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private static void extractEmail(BlockingQueue<Email> blockQueue) {
		System.out.println("extractEmail begin{}...");
		
	}

}
