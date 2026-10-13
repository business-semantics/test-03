package com.smartkyc.test.test03.security;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Authentication and secret management libraries managed by test-03-bom.
 */
public final class SecurityLibraries {

	/** One public type of every library this module depends on. */
	public static final List<Class<?>> USED = List.of(
			org.springframework.security.core.Authentication.class,
			org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder.class,
			org.springframework.security.oauth2.client.registration.ClientRegistration.class,
			org.springframework.security.oauth2.jwt.NimbusJwtDecoder.class,
			org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter.class,
			org.springframework.security.web.SecurityFilterChain.class,
			org.springframework.security.config.annotation.web.builders.HttpSecurity.class,
			org.springframework.security.ldap.authentication.BindAuthenticator.class,
			org.springframework.vault.core.VaultTemplate.class,
			org.springframework.security.saml2.provider.service.registration.RelyingPartyRegistration.class,
			org.springframework.security.kerberos.authentication.KerberosServiceAuthenticationProvider.class,
			org.springframework.security.kerberos.web.authentication.SpnegoEntryPoint.class,
			org.springframework.security.kerberos.client.KerberosRestTemplate.class,
			org.springframework.ldap.core.LdapTemplate.class);

	private SecurityLibraries() {
	}

	public static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(10);
	}
}
