package com.app.navneet;

import java.time.LocalDateTime;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.IntStream;

public class Producer implements Runnable {

	private final String name;
	private final Integer id;
	BlockingQueue<Message> message;
	private AtomicBoolean running = new AtomicBoolean();
	Integer count=0;

	public Producer(String name, Integer id, BlockingQueue<Message> message) {
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
				System.out.println("Start Prodicing Thread " + this.name);
                IntStream.range(0, 100).forEach(it->{
                	try {
                		Message msg= new Message(LocalDateTime.now().toString(), "Thread Send Message = "+it+" = "+Thread.currentThread().getName());
						this.message.offer(msg);
						System.out.println("Producing "+msg.toString()+"=== "+this.message.size());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						running.set(false);
						Thread.currentThread().interrupt();
						System.out.println("Stop Running "+this.running.get());
					}finally {
						
					}
                });
				Thread.sleep(2000);
  
			}

		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
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
