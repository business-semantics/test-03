package com.smartkyc.test.test03.api;

import java.util.List;

/**
 * REST, SOAP and XML binding libraries managed by test-03-bom.
 */
public final class ApiLibraries {

	/** One public type of every library this module depends on. */
	public static final List<Class<?>> USED = List.of(
			javax.xml.bind.JAXBContext.class,
			com.sun.xml.bind.v2.ContextFactory.class,
			jakarta.xml.bind.JAXBContext.class,
			org.glassfish.jaxb.runtime.v2.ContextFactory.class,
			jakarta.xml.ws.Service.class,
			jakarta.jws.WebService.class,
			io.swagger.v3.jaxrs2.integration.resources.OpenApiResource.class,
			io.swagger.v3.oas.annotations.Operation.class,
			io.swagger.v3.oas.integration.SwaggerConfiguration.class,
			org.glassfish.jersey.server.ResourceConfig.class,
			org.glassfish.jersey.servlet.init.JerseyServletContainerInitializer.class,
			org.glassfish.jersey.servlet.ServletContainer.class,
			org.glassfish.jersey.message.filtering.EntityFilteringFeature.class,
			org.glassfish.jersey.media.multipart.MultiPartFeature.class,
			org.glassfish.jersey.inject.hk2.Hk2InjectionManagerFactory.class,
			jakarta.servlet.http.HttpServlet.class,
			jakarta.ws.rs.Path.class,
			com.ctc.wstx.stax.WstxInputFactory.class,
			org.apache.cxf.jaxws.JaxWsProxyFactoryBean.class,
			org.apache.cxf.transport.http.HTTPConduit.class,
			org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor.class,
			org.apache.cxf.ws.addressing.WSAddressingFeature.class,
			org.apache.cxf.ws.policy.WSPolicyFeature.class,
			javax.wsdl.factory.WSDLFactory.class);

	private ApiLibraries() {
	}
}
