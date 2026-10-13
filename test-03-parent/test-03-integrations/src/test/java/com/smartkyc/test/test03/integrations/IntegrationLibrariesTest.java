package com.smartkyc.test.test03.integrations;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import java.util.stream.Stream;

import io.github.bucket4j.Bucket;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class IntegrationLibrariesTest {

	static Stream<Class<?>> usedLibraries() {
		return IntegrationLibraries.USED.stream();
	}

	@ParameterizedTest
	@MethodSource("usedLibraries")
	void libraryIsOnClasspath(Class<?> type) {
		assertThat(type.getPackage(), notNullValue());
	}

	@Test
	void extractsText() {
		assertThat(IntegrationLibraries.plainText("<p>know <b>your</b> customer</p>"), equalTo("know your customer"));
	}

	@Test
	void limitsRate() {
		Bucket bucket = IntegrationLibraries.rateLimit(1);
		assertThat(bucket.tryConsume(1), is(true));
		assertThat(bucket.tryConsume(1), is(false));
	}
}
