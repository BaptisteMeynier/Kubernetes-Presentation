package com.softeam.presentation.kubernetes.microprofile.service;

import com.softeam.presentation.kubernetes.microprofile.model.Portfolio;
import com.softeam.presentation.kubernetes.microprofile.model.PortfolioKey;
import com.softeam.presentation.kubernetes.microprofile.repository.Repository;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.Optional;

@Named
public class PortfolioService {

    @Inject
    private Repository repository;

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
