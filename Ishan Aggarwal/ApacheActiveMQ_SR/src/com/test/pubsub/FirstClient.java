package com.test.pubsub;

import java.util.Properties;

import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class FirstClient {
	private Context context = null;
	private TopicConnectionFactory factory = null;
	private TopicConnection connection = null;
	private TopicSession session = null;
	private Topic topic = null;
	private TopicPublisher publisher = null;

	public FirstClient() {
		Properties initialProperties = new Properties();
		initialProperties.put(InitialContext.INITIAL_CONTEXT_FACTORY,
				"org.exolab.jms.jndi.InitialContextFactory");
		initialProperties.put(InitialContext.PROVIDER_URL,
				"tcp://localhost:3035");
		try {
			context = new InitialContext();
			factory = (TopicConnectionFactory) context
					.lookup("topicConnectionFactry");
			topic = (Topic) context.lookup("MyTopic");
			connection = factory.createTopicConnection();
			session = connection.createTopicSession(false,
					TopicSession.AUTO_ACKNOWLEDGE);
			publisher = session.createPublisher(topic);
//			publisher.setDeliveryMode(DeliveryMode.PERSISTENT);
//			publisher.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
			EventMessage eventMessage = new EventMessage(1,
					"Message from FirstClient");
			ObjectMessage objectMessage = session.createObjectMessage();
			objectMessage.setObject(eventMessage);
			connection.start();
			publisher.publish(objectMessage);
			System.out.println(this.getClass().getName()
					+ " has sent a message : " + eventMessage);

		} catch (NamingException e) {
			e.printStackTrace();
		} catch (JMSException e) {
			e.printStackTrace();
		}
		if (context != null) {
			try {
				context.close();
			} catch (NamingException ex) {
				ex.printStackTrace();
			}
		}

		if (connection != null) {
			try {
				connection.close();
			} catch (JMSException ex) {
				ex.printStackTrace();
			}
		}
	}

	public void sendMessage() {

	}

	public static void main(String[] args) {
		FirstClient firstClient = new FirstClient();
		firstClient.sendMessage();
	}

}