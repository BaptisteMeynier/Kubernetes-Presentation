package com.softeam.presentation.kubernetes.microprofile.rest;

import com.softeam.presentation.kubernetes.microprofile.model.Portfolio;
import com.softeam.presentation.kubernetes.microprofile.rest.pagination.Paginated;
import com.softeam.presentation.kubernetes.microprofile.rest.param.PaginationParam;
import com.softeam.presentation.kubernetes.microprofile.rest.param.PortfolioParam;
import com.softeam.presentation.kubernetes.microprofile.service.PortfolioService;
import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Metered;
import org.eclipse.microprofile.metrics.annotation.Timed;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("portfolio")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Metered
@Counted(unit = MetricUnits.NONE,
        name = "itemsCheckedOut",
        absolute = true,
        monotonic = true,
        displayName = "Checkout items",
        description = "Metrics to show how many times checkoutItems method was called.",
        tags = {"checkout=items"})
@Timed(name = "itemsProcessed",
        description = "Metrics to monitor the times of get portfolio.",
        unit = MetricUnits.MILLISECONDS,
        absolute = true)
public class PortfolioEndpoint {

    @Inject
    private PortfolioService portfolioService;

    @GET
    public void doGet(
            @BeanParam PaginationParam queryParams,
            @Suspended AsyncResponse asyncResponse
    ) {

        int offset = queryParams.per_page * queryParams.page;

        final List<Portfolio> portfolios = portfolioService.getPortfolio(offset, queryParams.per_page);
        int total = portfolioService.countPortfolio();

        final Paginated<Portfolio> paginated =
                new Paginated<>(
                        portfolios,
                        queryParams.page,
                        queryParams.per_page,
                        total / queryParams.per_page,
                        total);

        asyncResponse.resume(paginated);
    }

    @POST
    public void doPost(
            @BeanParam PortfolioParam portfolioParam,
            @Suspended AsyncResponse asyncResponse
    ){
        final Portfolio portfolio =
                Portfolio.builder()
                .setAmount(portfolioParam.amount)
                .setDevise(portfolioParam.devise)
                .setManager(portfolioParam.manager);
        asyncResponse.resume(portfolioService.insertPortfolio(portfolio));
    }

    @PUT
    @Path("{id}")
    public void doPut(
            @PathParam("id") Long id,
            @BeanParam PortfolioParam portfolioParam,
            @Suspended AsyncResponse asyncResponse
    ){
        final Portfolio portfolio =
                Portfolio.builder()
                        .setId(id)
                        .setAmount(portfolioParam.amount)
                        .setDevise(portfolioParam.devise)
                        .setManager(portfolioParam.manager);
        asyncResponse.resume(portfolioService.updatePortfolio(portfolio));
    }

    @DELETE
    @Path("{id}")
    public void doDelete(
            @PathParam("id") Long id,
            @Suspended AsyncResponse asyncResponse
    ){
        asyncResponse.resume(portfolioService.deletePortfolio(id));
    }
}
