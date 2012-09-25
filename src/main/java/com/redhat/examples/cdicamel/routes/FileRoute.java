package com.redhat.examples.cdicamel.routes;

import org.apache.camel.builder.RouteBuilder;

public class FileRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("file:/tmp/data/inbox").to("file:/tmp/data/outbox");
	}	
}
