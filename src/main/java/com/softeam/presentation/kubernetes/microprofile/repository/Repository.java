package com.softeam.presentation.kubernetes.microprofile.repository;


import javax.annotation.Resource;
import javax.inject.Named;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Named
public class Repository {

    private static final String SELECT_QUERY = "SELECT ID,AMOUNT,DEVISE,MANAGER FROM PORTFOLIO ORDER BY id ASC LIMIT %d,%d";

    @Resource(lookup = "java:jboss/datasources/PortfolioDS")
    private DataSource ds;

    public List<String> getPortfolio(int offset, int totalReturnedValue) {

        final String selectQuery = String.format(SELECT_QUERY, offset, offset + totalReturnedValue);
        try (final Connection connection = ds.getConnection();
             final Statement statement = connection.createStatement();
             final ResultSet resultSet = statement.executeQuery(selectQuery);
        ) {


        } catch (SQLException e) {
            e.printStackTrace();
        }
        //    Portfolio portfolio = Portfolio.builder().setId(1).setAmount(10).setDevise(Devise.DOLLAR).setManager("Antoine");
        return null;
    }

    public boolean insertPortfolio() {
        return false;
    }


}
