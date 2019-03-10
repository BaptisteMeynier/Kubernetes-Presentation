package com.softeam.presentation.kubernetes.microprofile;

import com.softeam.presentation.kubernetes.microprofile.model.Portfolio;
import com.softeam.presentation.kubernetes.microprofile.repository.Repository;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(Arquillian.class)
//@DefaultDeployment(type = DefaultDeployment.Type.WAR)
public class RepositoryTest {

    @ArquillianResource
    InitialContext context;

    @Inject
    Repository repository;

    @Deployment
    public static Archive createDeployment() {
        return ShrinkWrap.create(WebArchive.class)
                .addPackages(true,"com.softeam.presentation.kubernetes.microprofile")
                .addAsResource("import.sql")
                .addAsResource("project-defaults.yml")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Test
    public void testDataSourceIsBound() throws Exception {
        DataSource ds = (DataSource) context.lookup("java:jboss/datasources/PortfolioDS");
        assertNotNull( ds );
    }

    @Test
    public void shouldGetPaginatedResult() throws Exception {
        List<Portfolio> portfolio = repository.getPortfolio(0, 2);
        Assert.assertEquals(2,portfolio.size());
    }
}