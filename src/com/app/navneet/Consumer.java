package com.app.navneet;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class Consumer implements Runnable{
	private final String name;
	private final Integer id;
	BlockingQueue<Message> message;
	private AtomicBoolean running = new AtomicBoolean();

	public Consumer(String name, Integer id, BlockingQueue<Message> message) {
		super();
		this.name = name;
		this.id = id;
		this.message = message;
		running.set(true);

	}

	@Override
	public void run() {
		try {
			while (running.get()) {
				System.out.println("Start Consuming Thread " + this.name+"  "+this.message.size());
				System.out.println(this.message.take().toString());
				Thread.sleep(100);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			Thread.currentThread().interrupt();
			running.set(false);
			System.out.println("Stop Running "+this.running.get());
		}

	}
	
	public void setStop(boolean flag) {
		this.running.set(flag);
	}

	@Override
	public String toString() {
		return "Producer [name=" + name + ", id=" + id + ", message=" + message + "]";
	}

}
