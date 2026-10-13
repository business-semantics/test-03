package com.smartkyc.test.test03.messaging;

import java.util.List;

import jakarta.jms.ConnectionFactory;

/**
 * JMS brokers and clients managed by test-03-bom.
 */
public final class MessagingLibraries {

	/** One public type of every library this module depends on. */
	public static final List<Class<?>> USED = List.of(
			jakarta.jms.ConnectionFactory.class,
			com.ibm.mq.jakarta.jms.MQConnectionFactory.class,
			org.apache.activemq.ActiveMQConnectionFactory.class,
			org.apache.activemq.jms.pool.PooledConnectionFactory.class,
			com.solacesystems.jms.SolConnectionFactory.class,
			org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory.class,
			io.netty.handler.codec.ByteToMessageDecoder.class,
			io.netty.handler.proxy.HttpProxyHandler.class,
			io.netty.handler.codec.http.HttpObjectAggregator.class);

	private MessagingLibraries() {
	}

	public static ConnectionFactory artemis(String brokerUrl) {
		return new org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory(brokerUrl);
	}
}
