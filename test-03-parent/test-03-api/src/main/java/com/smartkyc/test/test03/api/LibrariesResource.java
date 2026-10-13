package com.smartkyc.test.test03.api;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("libraries")
public class LibrariesResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Operation(summary = "Lists the libraries used by the API module")
	public List<String> list() {
		return ApiLibraries.USED.stream().map(Class::getName).toList();
	}
}
