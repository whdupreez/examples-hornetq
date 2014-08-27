package com.willydupreez.examples.hornetq;

import java.util.ArrayList;
import java.util.List;

import org.hornetq.api.core.TransportConfiguration;
import org.hornetq.core.config.Configuration;
import org.hornetq.core.config.impl.ConfigurationImpl;
import org.hornetq.core.remoting.impl.netty.NettyAcceptorFactory;
import org.hornetq.core.remoting.impl.netty.NettyConnectorFactory;
import org.hornetq.jms.server.config.ConnectionFactoryConfiguration;
import org.hornetq.jms.server.config.JMSConfiguration;
import org.hornetq.jms.server.config.JMSQueueConfiguration;
import org.hornetq.jms.server.config.impl.ConnectionFactoryConfigurationImpl;
import org.hornetq.jms.server.config.impl.JMSConfigurationImpl;
import org.hornetq.jms.server.config.impl.JMSQueueConfigurationImpl;

public class HornetQConfigFactory {

	public JMSConfiguration createJmsConfig(JmsProperties properties) {

		List<String> connectorNames = new ArrayList<String>();
		connectorNames.add("connector");
		ConnectionFactoryConfiguration cfConfig = new ConnectionFactoryConfigurationImpl(
				"cf", false, connectorNames, "/cf");

		JMSQueueConfiguration queueConfig = new JMSQueueConfigurationImpl(
				"queue1", null, false, "/queue/queue1");

		JMSConfiguration jmsConfig = new JMSConfigurationImpl();
		jmsConfig.getConnectionFactoryConfigurations().add(cfConfig);
		jmsConfig.getQueueConfigurations().add(queueConfig);
		return jmsConfig;
	}

	public Configuration createCoreConfig(JmsProperties properties) {
		Configuration coreConfig = new ConfigurationImpl();
		coreConfig.setPersistenceEnabled(properties.isJmsPersistenceEnabled());
		coreConfig.setJournalDirectory(properties.getJmsJournalDirectory());
		coreConfig.setSecurityEnabled(properties.isJmsSecurityEnabled());
		coreConfig.getAcceptorConfigurations().add(acceptorConfig());
		coreConfig.getConnectorConfigurations().put("connector", connectorConfig());
		return coreConfig;
	}

	private TransportConfiguration acceptorConfig() {
		return new TransportConfiguration(NettyAcceptorFactory.class.getName());
	}

	private TransportConfiguration connectorConfig() {
		return new TransportConfiguration(NettyConnectorFactory.class.getName());
	}

}
