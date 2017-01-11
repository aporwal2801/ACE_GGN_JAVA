package com.example;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.activemq.ActiveMQConnection;

public class Receiver {
	private ConnectionFactory factory = null;
	private Connection connection = null;
	private Session session = null;
	private Destination destination = null;
	private MessageConsumer consumer = null;

	public Receiver() {

	}

	public void receiveMessage() throws NamingException {
		try {

			Context ctx = new InitialContext();
			// QueueConnectionFactory queueConnectionFactory =
			// (QueueConnectionFactory) ctx.lookup("SAMPLEQUEUE");
			QueueConnectionFactory queueConnectionFactory = (QueueConnectionFactory) ctx
					.lookup(ActiveMQConnection.DEFAULT_BROKER_URL);

			Queue queue = (Queue) ctx.lookup("SAMPLEQUEUE");

			QueueConnection connection = queueConnectionFactory
					.createQueueConnection();
			QueueSession session = connection.createQueueSession(false,
					Session.AUTO_ACKNOWLEDGE);

			// Session session = connection.createSession(false,
			// Session.AUTO_ACKNOWLEDGE);
			// int i = 0;
			// TextMessage message1 = session.createTextMessage();
			// message1.setText("Hello Ishan " + i);

			QueueSender sender = session.createSender(queue);

			QueueReceiver receiver = session.createReceiver(queue);

			connection.start();

			while (true) {

				Message message = receiver.receive();
				TextMessage textMessage = (TextMessage) message;
				System.out.println("Received : " + textMessage.getText());

				// sender.send(message1);
				// System.out.println("Sent: " + message1.getText());
				// i++;
				// message1.setText("Hello Ishan : " + i);
			}

//			factory = new ActiveMQConnectionFactory(
//					ActiveMQConnection.DEFAULT_BROKER_URL);
//			connection = factory.createConnection();
//			connection = factory.createConnection();
//			connection.start();
//			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
//			destination = session.createQueue("SAMPLEQUEUE");
//			consumer = session.createConsumer(destination);
//			Message message = consumer.receive();
//
//			if (message instanceof TextMessage) {
//				TextMessage text = (TextMessage) message;
//				System.out.println("Message is : " + text.getText());
//			}
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws NamingException {
		Receiver receiver = new Receiver();
		receiver.receiveMessage();
	}
}