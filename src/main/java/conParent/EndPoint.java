package conParent;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;



public abstract class EndPoint {

	protected Channel channel;
	protected Connection con;
	protected String endName;
	
	public EndPoint(String endName) throws IOException, TimeoutException {
		this.endName = endName;
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		con = factory.newConnection();
		channel = con.createChannel();
		channel.queueDeclare(endName, false, false, false, null);
	}
	
	public void close() throws IOException, TimeoutException {
		this.channel.close();
		this.con.close();
	}
	
}
