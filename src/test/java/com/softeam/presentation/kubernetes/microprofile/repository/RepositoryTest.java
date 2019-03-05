package com.softeam.presentation.kubernetes.microprofile.repository;

import com.softeam.presentation.kubernetes.microprofile.model.Portfolio;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.wildfly.swarm.arquillian.DefaultDeployment;

import javax.inject.Inject;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(Arquillian.class)
@DefaultDeployment(type = DefaultDeployment.Type.WAR)
public class RepositoryTest {

    @ArquillianResource
    InitialContext context;

    @Inject
    Repository repository;

    @Test
    public void testDataSourceIsBound() throws Exception {
        DataSource ds = (DataSource) context.lookup("java:jboss/datasources/PortfolioDS");
        assertNotNull( ds );
    }

    @Test
    public void shouldGetPaginatedResult() throws Exception {
        List<String> portfolio = repository.getPortfolio(0, 2);
    }
}