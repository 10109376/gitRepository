package test;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

import busi.Producer;
import busi.QueueConsumer;

public class MainTest {
	
	public MainTest() throws IOException, TimeoutException {
		//
		QueueConsumer consumer = new QueueConsumer("queue");
		Thread consumerthred = new Thread(consumer);
		consumerthred.start();
		
		Producer producer = new Producer("queue");
		for(int i = 0;i < 100;i++) {
			Map map = new HashMap();
			map.put("nums", i+"");
			producer.sendMessage((Serializable) map);
			System.out.println("Message Number "+ i +" sent.");
		}
	}

	public static void main(String[] args) throws IOException, TimeoutException {
		new MainTest();
	}
}
