package com.softeam.presentation.kubernetes.microprofile.repository;



import javax.annotation.Resource;
import javax.inject.Named;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@Named
public class Repository {

    private static final String SELECT_QUERY = "SELECT * FROM PORTFOLIO ORDER BY id ASC LIMIT %d,%d";

    @Resource(lookup = "java:jboss/datasources/PortfolioDS")
    private DataSource ds;

    public List<String> getPortfolio(int offset, int totalReturnedValue) {
        try (Connection connection = ds.getConnection()) {
            final String selectQuery = String.format(SELECT_QUERY, offset, offset + totalReturnedValue);
            final String s = connection.nativeSQL(selectQuery);
            System.out.println(s);
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
