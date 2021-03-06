package com.softeam.presentation.kubernetes.portfolio.business.service;

import com.softeam.presentation.kubernetes.portfolio.business.model.Portfolio;
import com.softeam.presentation.kubernetes.portfolio.business.model.PortfolioKey;
import com.softeam.presentation.kubernetes.portfolio.business.repository.RepositoryPort;

import java.util.List;
import java.util.Optional;

public class PortfolioService implements PortfolioServicePort {

    private RepositoryPort repository;

    public PortfolioService(RepositoryPort repository) {
        this.repository = repository;
    }

    public List<Portfolio> getPortfolios(int offset, int totalReturnedValue ){
        return repository.getPortfolios(offset,totalReturnedValue);
    }
    public Optional<Portfolio> getPortfolio(final PortfolioKey key){
        return repository.getPortfolio(key);
    }
    public boolean insertPortfolio(final Portfolio portfolio){
        return repository.insertPortfolio(portfolio);
    }
    public boolean updatePortfolio(final Portfolio portfolio){
        return repository.updatePortfolio(portfolio);
    }
    public boolean deletePortfolio(final PortfolioKey key){
        return repository.deletePortfolio(key);
    }
    public int countPortfolio() {
        return repository.countPorfolio();
    }
}
