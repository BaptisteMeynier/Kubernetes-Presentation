package com.softeam.presentation.kubernetes.microprofile.rest;

import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import com.softeam.presentation.kubernetes.microprofile.rest.provider.LinkPaginationContainerResponseFilter;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("api/v1")
public class PortfolioApplication extends Application {

    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>(3);
        classes.add(PortfolioEndpoint.class);
        classes.add(LinkPaginationContainerResponseFilter.class);
        classes.add(JacksonJaxbJsonProvider.class);
        return classes;
    }
}
