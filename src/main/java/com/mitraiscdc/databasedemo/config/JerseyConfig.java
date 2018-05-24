package com.mitraiscdc.databasedemo.config;

import com.mitraiscdc.databasedemo.resource.PersonResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.ApplicationPath;

@Configuration
@ApplicationPath("/")
public class JerseyConfig extends ResourceConfig {

//    register resources
    public JerseyConfig() {
        register(PersonResource.class);
    }
}
