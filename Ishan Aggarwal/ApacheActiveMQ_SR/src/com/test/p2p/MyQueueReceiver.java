package com.test.p2p;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class MyQueueReceiver {

	private Message msg = null;
	private TextMessage textMsg = null;

	public MyQueueReceiver() {

	}

	public void receiveMessage() {
		try {

			Context ctx = new InitialContext();

			QueueConnectionFactory cf = (QueueConnectionFactory) ctx
					.lookup("QueueConnectionFactory");
			Queue queue = (Queue) ctx.lookup("MyQueue");

			QueueConnection connection = cf.createQueueConnection();

			QueueSession session = connection.createQueueSession(false,
					Session.AUTO_ACKNOWLEDGE);

			QueueReceiver receiver = session.createReceiver(queue);

			connection.start();

			while (true) {
				msg = receiver.receive();
				textMsg = (TextMessage) msg;
				System.out.println(textMsg.getText());
			}

		} catch (JMSException | NamingException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		MyQueueReceiver receiver = new MyQueueReceiver();
		receiver.receiveMessage();
	}
}