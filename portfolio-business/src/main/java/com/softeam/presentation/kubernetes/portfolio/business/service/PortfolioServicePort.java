package com.softeam.presentation.kubernetes.portfolio.business.service;

import com.softeam.presentation.kubernetes.portfolio.business.model.Portfolio;
import com.softeam.presentation.kubernetes.portfolio.business.model.PortfolioKey;
import com.softeam.presentation.kubernetes.portfolio.business.repository.RepositoryPort;

import java.util.List;
import java.util.Optional;

public interface PortfolioServicePort {

    List<Portfolio> getPortfolios(int offset, int totalReturnedValue);

    Optional<Portfolio> getPortfolio(final PortfolioKey key);

    boolean insertPortfolio(final Portfolio portfolio);

    boolean updatePortfolio(final Portfolio portfolio);

    boolean deletePortfolio(final PortfolioKey key);

    int countPortfolio();
}
