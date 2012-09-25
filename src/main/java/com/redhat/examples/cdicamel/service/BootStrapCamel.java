package com.redhat.examples.cdicamel.service;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import org.apache.camel.component.cdi.CdiCamelContext;

import com.redhat.examples.cdicamel.routes.FileRoute;

@Singleton
@Startup
public class BootStrapCamel {

	@Inject
	Logger logger;
	
	@Inject
    CdiCamelContext camelCtx;

    @Inject
    FileRoute fileRoute;
    
    @PostConstruct
    public void init() throws Exception {
    	logger.info("Registering FileRoute to CAMEL context");
    	camelCtx.addRoutes(fileRoute);
    	
    	logger.info("FileRoute successfully added...");
    	
    	camelCtx.start();
    	
    	logger.info("Started CAMEL");
    }
    
    @PreDestroy
    public void stop() throws Exception {
       camelCtx.stop();
       logger.info("CAMEL stopped");
    }
    
    
    
    
	
}
