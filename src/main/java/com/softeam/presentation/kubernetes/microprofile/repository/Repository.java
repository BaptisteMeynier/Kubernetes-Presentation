package com.softeam.presentation.kubernetes.microprofile.repository;


import com.softeam.presentation.kubernetes.microprofile.model.Portfolio;
import com.softeam.presentation.kubernetes.microprofile.model.enums.Devise;

import javax.annotation.Resource;
import javax.inject.Named;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Named
public class Repository {

    private static final String COUNT_QUERY = "SELECT count(ID) FROM PORTFOLIO";
    private static final String SELECT_QUERY = "SELECT ID,AMOUNT,DEVISE,MANAGER FROM PORTFOLIO ORDER BY id ASC LIMIT %d,%d";
    private static final String INSERT_QUERY = "INSERT INTO PORTFOLIO (AMOUNT,DEVISE,MANAGER) VALUES ('%d', '%s', '%s')";
    private static final String UPDATE_QUERY = "UPDATE PORTFOLIO SET AMOUNT=%d, DEVISE='%s' ,MANAGER='%s' WHERE ID=%d";
    private static final String DELETE_QUERY = "DELETE FROM PORTFOLIO WHERE ID=%d";

    @Resource(lookup = "java:jboss/datasources/PortfolioDS")
    private DataSource ds;

    public List<Portfolio> getPortfolio(int offset, int totalReturnedValue) {

        final List<Portfolio> portfolios = new ArrayList<>();
        final String selectQuery = String.format(SELECT_QUERY, offset, totalReturnedValue);
        System.out.println(selectQuery);
        try (final Connection connection = ds.getConnection();
             final Statement statement = connection.createStatement();
             final ResultSet resultSet = statement.executeQuery(selectQuery);
        ) {
            while (resultSet.next()) {
                portfolios.add(
                        Portfolio.builder()
                                .setId(resultSet.getLong("ID"))
                                .setAmount(resultSet.getInt("AMOUNT"))
                                .setDevise(Devise.valueOf(resultSet.getString("DEVISE")))
                                .setManager(resultSet.getString("MANAGER")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return portfolios;
    }

    public boolean insertPortfolio(final Portfolio portfolio) {
        Objects.requireNonNull(portfolio);
        final String insertQuery = String.format(INSERT_QUERY, portfolio.getAmount(), portfolio.getDevise(), portfolio.getManager());
        return processSimpleQuery(insertQuery);
    }

    public boolean updatePortfolio(final Portfolio portfolio) {
        Objects.requireNonNull(portfolio);
        Objects.requireNonNull(portfolio.getId());
        final String update = String.format(UPDATE_QUERY, portfolio.getAmount(), portfolio.getDevise(), portfolio.getManager(),portfolio.getId());
        return processSimpleQuery(update);
    }


    public boolean deletePortfolio(final Long id) {
        Objects.requireNonNull(id);
        final String deleteQuery = String.format(DELETE_QUERY, id);
        return processSimpleQuery(deleteQuery);
    }

    private boolean processSimpleQuery(final String query){
        System.out.println(query);
        boolean execute =false;
        try (final Connection connection = ds.getConnection();
             final Statement statement = connection.createStatement()
        ) {
            execute = statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return execute;
    }


    public int countPorfolio() {
        int total =0;
        try (final Connection connection = ds.getConnection();
             final Statement statement = connection.createStatement();
             final ResultSet resultSet = statement.executeQuery(COUNT_QUERY);
        ) {
            if(resultSet.next()) {
                total = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total;
    }
}
