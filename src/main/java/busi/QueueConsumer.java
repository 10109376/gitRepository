package busi;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

import org.apache.commons.lang.SerializationUtils;

import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.ShutdownSignalException;
import com.rabbitmq.client.AMQP.BasicProperties;

import conParent.EndPoint;

public class QueueConsumer extends EndPoint implements Runnable,Consumer {

	public QueueConsumer(String endName) throws IOException, TimeoutException {
		super(endName);
		// TODO Auto-generated constructor stub
	}

	public void run() {
		try {
			channel.basicConsume(endName, true, QueueConsumer.this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void handleCancel(String arg0) throws IOException {
		// TODO Auto-generated method stub
		
	}

	public void handleCancelOk(String arg0) {
		// TODO Auto-generated method stub
		
	}

	//Called when consumer is registered
	public void handleConsumeOk(String arg0) {
		// TODO Auto-generated method stub
		System.out.println("Consumer "+arg0+" registered");
	}
	
	//Called when new message is available.
	public void handleDelivery(String arg0, Envelope arg1,
			BasicProperties arg2, byte[] arg3) throws IOException {
		// TODO Auto-generated method stub
		Map map = (HashMap) SerializationUtils.deserialize(arg3);
		System.out.println("Message Number " + map.get("nums") + " received.");
	}

	public void handleRecoverOk(String arg0) {
		// TODO Auto-generated method stub
		
	}

	public void handleShutdownSignal(String arg0, ShutdownSignalException arg1) {
		// TODO Auto-generated method stub
		
	}
	
}
