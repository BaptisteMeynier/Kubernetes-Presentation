package com.softeam.presentation.kubernetes.microprofile.service;

import com.softeam.presentation.kubernetes.microprofile.model.Portfolio;
import com.softeam.presentation.kubernetes.microprofile.model.PortfolioKey;
import com.softeam.presentation.kubernetes.microprofile.repository.Repository;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class PortfolioService {

    @Inject
    private Repository repository;

    public List<Portfolio> getPortfolio(int offset, int totalReturnedValue ){
        return repository.getPortfolio(offset,totalReturnedValue);
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
