package com.smartkyc.test.test03.persistence;

import java.sql.Driver;
import java.util.List;
import java.util.Map;

/**
 * JDBC drivers and transaction APIs managed by test-03-bom (hibernate-c3p0 is runtime only).
 */
public final class JdbcDrivers {

	/** One public type of every library this module depends on at compile time. */
	public static final List<Class<?>> USED = List.of(
			javax.transaction.UserTransaction.class,
			org.postgresql.Driver.class,
			oracle.jdbc.OracleDriver.class,
			com.microsoft.sqlserver.jdbc.SQLServerDriver.class);

	private static final Map<String, Class<? extends Driver>> DRIVERS = Map.of(
			"postgresql", org.postgresql.Driver.class,
			"oracle", oracle.jdbc.OracleDriver.class,
			"sqlserver", com.microsoft.sqlserver.jdbc.SQLServerDriver.class);

	private JdbcDrivers() {
	}

	public static Class<? extends Driver> forUrl(String jdbcUrl) {
		String vendor = jdbcUrl.split(":")[1];
		Class<? extends Driver> driver = DRIVERS.get(vendor);
		if (driver == null) {
			throw new IllegalArgumentException("Unsupported database: " + vendor);
		}
		return driver;
	}
}
