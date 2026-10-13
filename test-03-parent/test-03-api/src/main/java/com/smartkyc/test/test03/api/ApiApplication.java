package com.smartkyc.test.test03.api;

import com.fasterxml.jackson.jakarta.rs.json.JacksonJsonProvider;
import io.swagger.v3.jaxrs2.integration.resources.OpenApiResource;
import jakarta.ws.rs.ApplicationPath;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("api")
public class ApiApplication extends ResourceConfig {

	public ApiApplication() {
		register(LibrariesResource.class);
		register(OpenApiResource.class);
		register(MultiPartFeature.class);
		register(JacksonJsonProvider.class);
	}
}
