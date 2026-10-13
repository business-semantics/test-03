package com.smartkyc.test.test03.reporting;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

import java.util.Map;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class ReportingLibrariesTest {

	static Stream<Class<?>> usedLibraries() {
		return ReportingLibraries.USED.stream();
	}

	@ParameterizedTest
	@MethodSource("usedLibraries")
	void libraryIsOnClasspath(Class<?> type) {
		assertThat(type.getPackage(), notNullValue());
	}

	@Test
	void rendersTemplate() {
		assertThat(ReportingLibraries.renderHtml("<p th:text=\"${name}\">x</p>", Map.of("name", "test-03")), equalTo("<p>test-03</p>"));
	}
}
