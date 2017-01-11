package com.example;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class Sender {

	public Sender() {

	}

	public void sendMessage() throws NamingException {

		try {

			QueueConnectionFactory queueConnectionFactory = new ActiveMQConnectionFactory(
					ActiveMQConnection.DEFAULT_BROKER_URL);
			QueueConnection connection = queueConnectionFactory
					.createQueueConnection();
			QueueSession session = connection.createQueueSession(false,
					Session.AUTO_ACKNOWLEDGE);
			Queue queue = (Queue) session.createQueue("SAMPLEQUEUE");
			MessageProducer producer = session.createProducer(queue);

			int i = 0;
			TextMessage message1 = session.createTextMessage();
			message1.setText("Hello Ishan " + i);

			QueueSender sender = session.createSender(queue);
			while (true) {
				sender.send(message1);
				System.out.println("Sent: " + message1.getText());
				i++;
				message1.setText("Hello Ishan : " + i);
			}
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws NamingException {
		Sender sender = new Sender();
		sender.sendMessage();
	}

}