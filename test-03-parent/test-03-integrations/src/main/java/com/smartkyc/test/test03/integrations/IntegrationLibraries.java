package com.smartkyc.test.test03.integrations;

import java.time.Duration;
import java.util.List;

import io.github.bucket4j.Bucket;
import org.jsoup.Jsoup;

/**
 * Libraries used by external data integrations, managed by test-03-bom.
 */
public final class IntegrationLibraries {

	/** One public type of every library this module depends on. */
	public static final List<Class<?>> USED = List.of(
			gnu.getopt.Getopt.class,
			io.github.bucket4j.Bucket.class,
			org.sweble.wikitext.engine.WtEngineImpl.class,
			org.sweble.wikitext.parser.ParserConfig.class,
			org.scribe.builder.ServiceBuilder.class,
			org.jsoup.Jsoup.class,
			com.knuddels.jtokkit.Encodings.class);

	private IntegrationLibraries() {
	}

	public static String plainText(String html) {
		return Jsoup.parse(html).text();
	}

	public static Bucket rateLimit(long requestsPerMinute) {
		return Bucket.builder().addLimit(limit -> limit.capacity(requestsPerMinute).refillGreedy(requestsPerMinute, Duration.ofMinutes(1))).build();
	}
}
