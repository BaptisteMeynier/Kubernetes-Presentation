package com.softeam.presentation.kubernetes.microprofile.rest.health;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.health.Health;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.HealthCheckResponseBuilder;
import org.wildfly.swarm.spi.runtime.annotations.ConfigurationValue;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

@Health
@ApplicationScoped
public class PortfolioHealthCheck implements HealthCheck {

    @Resource(lookup = "java:jboss/datasources/PortfolioDS")
    private DataSource datasource;

    @Inject
    @ConfigurationValue("health.datasource.max")
    private int TIMEOUT;

    @Override
    public HealthCheckResponse call() {

        HealthCheckResponseBuilder responseBuilder = HealthCheckResponse.named("portfolio");
        try {
            Connection connection = datasource.getConnection();
            boolean isValid = connection.isValid(500);

            DatabaseMetaData metaData = connection.getMetaData();

            responseBuilder = responseBuilder
                    .withData("databaseProductName", metaData.getDatabaseProductName())
                    .withData("databaseProductVersion", metaData.getDatabaseProductVersion())
                    .withData("driverName", metaData.getDriverName())
                    .withData("driverVersion", metaData.getDriverVersion())
                    .withData("isValid", isValid);

            return responseBuilder.state(isValid).build();


        } catch(SQLException e) {
            responseBuilder = responseBuilder
                    .withData("exceptionMessage", e.getMessage());
            return responseBuilder.down().build();
        }
    }
}
