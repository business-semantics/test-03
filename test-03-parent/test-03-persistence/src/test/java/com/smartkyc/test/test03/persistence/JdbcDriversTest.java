package com.smartkyc.test.test03.persistence;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class JdbcDriversTest {

	static Stream<Class<?>> usedLibraries() {
		return JdbcDrivers.USED.stream();
	}

	@ParameterizedTest
	@MethodSource("usedLibraries")
	void libraryIsOnClasspath(Class<?> type) {
		assertThat(type.getPackage(), notNullValue());
	}

	@Test
	void selectsDriverByUrl() {
		assertThat(JdbcDrivers.forUrl("jdbc:oracle:thin:@localhost:1521/XE"), equalTo(oracle.jdbc.OracleDriver.class));
	}
}
