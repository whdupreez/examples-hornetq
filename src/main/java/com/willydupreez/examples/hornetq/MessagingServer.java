package com.willydupreez.examples.hornetq;

import org.hornetq.jms.server.embedded.EmbeddedJMS;

public class MessagingServer {

	private EmbeddedJMS jmsServer;

	public void init(JmsProperties properties) {
		HornetQConfigFactory factory = new HornetQConfigFactory();

		jmsServer = new EmbeddedJMS();
		jmsServer.setConfiguration(factory.createCoreConfig(properties));
		jmsServer.setJmsConfiguration(factory.createJmsConfig(properties));
	}

	public void start() {
		try {
			jmsServer.start();
		} catch (Exception e) {
			throw new MessagingException("Failed to start JMS Server", e);
		}
	}

	public void stop() {
		try {
			jmsServer.stop();
		} catch (Exception e) {
			throw new MessagingException("Failed to stop JMS Server", e);
		}
	}

}
