package com.softeam.presentation.kubernetest.portfolio.webservice.provider;

import com.softeam.presentation.kubernetes.portfolio.business.repository.RepositoryPort;
import com.softeam.presentation.kubernetes.portfolio.business.service.PortfolioService;
import com.softeam.presentation.kubernetes.portfolio.business.service.PortfolioServicePort;
import com.softeam.presentation.kubernetest.portfolio.persistence.repository.SqlRepositoryAdapter;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

@ApplicationScoped
public class PortfolioProvider {

    @Inject
    private RepositoryPort repositoryPort;

    @Produces
    public PortfolioServicePort getPortfolioService(){
        return new PortfolioService(repositoryPort);
    }


}
