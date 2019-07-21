package com.app.navneet;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingApp {

	public static void main(String[] args) {
		BlockingQueue<Message> queues=new ArrayBlockingQueue<Message>(100);

		Thread producer=new Thread(new Producer("Producer", 1, queues), "Producer");
		Thread consumer=new Thread(new Consumer("Consumer", 1, queues), "Consumer");
		Thread consumer2=new Thread(new Consumer("consumer2", 1, queues), "consumer2");
		producer.start();
		consumer.start();
		consumer2.start();


	}

}
