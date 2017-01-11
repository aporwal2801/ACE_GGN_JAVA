package com.test.p2p;

import java.util.Scanner;

import javax.jms.Connection;
import javax.jms.JMSException;
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

public class MyQueueSender {

	private Context ctx = null;
	private QueueConnectionFactory cf = null;
	private Queue queue = null;
	private QueueConnection connection = null;
	private QueueSession session = null;
	private QueueSender sender = null;
	private TextMessage msg = null;

	public MyQueueSender() {

	}

	public void sendMessage() {

		try {

			ctx = new InitialContext();

			cf = (QueueConnectionFactory) ctx.lookup("QueueConnectionFactory");
			queue = (Queue) ctx.lookup("MyQueue");

			connection = cf.createQueueConnection();

			session = connection.createQueueSession(false,
					Session.AUTO_ACKNOWLEDGE);

			sender = (QueueSender) session.createSender(queue);

			msg = session.createTextMessage();

			Scanner scanner = new Scanner(System.in);

			while (true) {
				msg.setText("Sending [ " + scanner.nextLine() + " ]");
				sender.send(msg);
//				sender.send
			}

		} catch (JMSException | NamingException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		MyQueueSender queueSender = new MyQueueSender();
		queueSender.sendMessage();
	}

}