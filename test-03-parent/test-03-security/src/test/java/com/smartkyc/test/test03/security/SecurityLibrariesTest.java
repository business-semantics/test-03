package com.smartkyc.test.test03.security;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.security.crypto.password.PasswordEncoder;

class SecurityLibrariesTest {

	static Stream<Class<?>> usedLibraries() {
		return SecurityLibraries.USED.stream();
	}

	@ParameterizedTest
	@MethodSource("usedLibraries")
	void libraryIsOnClasspath(Class<?> type) {
		assertThat(type.getPackage(), notNullValue());
	}

	@Test
	void hashesPasswords() {
		PasswordEncoder encoder = SecurityLibraries.passwordEncoder();
		assertThat(encoder.matches("secret", encoder.encode("secret")), is(true));
	}
}
