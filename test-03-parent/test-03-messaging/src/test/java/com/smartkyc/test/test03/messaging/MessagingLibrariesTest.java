package com.smartkyc.test.test03.messaging;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.notNullValue;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class MessagingLibrariesTest {

	static Stream<Class<?>> usedLibraries() {
		return MessagingLibraries.USED.stream();
	}

	@ParameterizedTest
	@MethodSource("usedLibraries")
	void libraryIsOnClasspath(Class<?> type) {
		assertThat(type.getPackage(), notNullValue());
	}

	@Test
	void createsArtemisFactory() {
		assertThat(MessagingLibraries.artemis("tcp://localhost:61616"),
				instanceOf(org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory.class));
	}
}
