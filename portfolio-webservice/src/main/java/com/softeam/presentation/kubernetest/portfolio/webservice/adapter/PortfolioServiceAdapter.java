package com.softeam.presentation.kubernetest.portfolio.webservice.adapter;

import com.softeam.presentation.kubernetes.portfolio.business.model.Portfolio;
import com.softeam.presentation.kubernetes.portfolio.business.model.PortfolioKey;
import com.softeam.presentation.kubernetes.portfolio.business.service.PortfolioServicePort;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.Optional;

@Named
public class PortfolioServiceAdapter {

    @Inject
    private PortfolioServicePort portfolioServicePort;

    public List<Portfolio> getPortfolios(int offset, int totalReturnedValue){
        return portfolioServicePort.getPortfolios(offset, totalReturnedValue);
    }

    public Optional<Portfolio> getPortfolio(final PortfolioKey key){
        return portfolioServicePort.getPortfolio(key);
    }

    public boolean insertPortfolio(final Portfolio portfolio){
        return portfolioServicePort.insertPortfolio(portfolio);
    }

    public boolean updatePortfolio(final Portfolio portfolio){
        return portfolioServicePort.updatePortfolio(portfolio);
    }

    public boolean deletePortfolio(final PortfolioKey key){
        return portfolioServicePort.deletePortfolio( key);
    }

    public int countPortfolio(){
        return portfolioServicePort.countPortfolio();
    }

}
