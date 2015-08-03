package busi;

import java.io.IOException;
import java.io.Serializable;
import java.util.concurrent.TimeoutException;

import org.apache.commons.lang.SerializationUtils;

import conParent.EndPoint;

public class Producer extends EndPoint {

	public Producer(String endName) throws IOException, TimeoutException {
		super(endName);
		// TODO Auto-generated constructor stub
	}
	
	public void sendMessage(Serializable object) throws IOException {
		channel.basicPublish("", endName, null, SerializationUtils.serialize(object));
	}
}
