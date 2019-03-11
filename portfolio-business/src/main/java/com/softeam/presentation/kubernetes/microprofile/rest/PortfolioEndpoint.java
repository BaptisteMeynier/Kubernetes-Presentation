package com.softeam.presentation.kubernetes.microprofile.rest;

import com.softeam.presentation.kubernetes.microprofile.model.Portfolio;
import com.softeam.presentation.kubernetes.microprofile.model.PortfolioKey;
import com.softeam.presentation.kubernetes.microprofile.rest.pagination.Page;
import com.softeam.presentation.kubernetes.microprofile.rest.param.PaginationParam;
import com.softeam.presentation.kubernetes.microprofile.rest.param.PortfolioParam;
import com.softeam.presentation.kubernetes.microprofile.rest.param.validation.UpdatePortfolio;
import com.softeam.presentation.kubernetes.microprofile.service.PortfolioService;
import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Metered;
import org.eclipse.microprofile.metrics.annotation.Timed;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.Validator;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;
import javax.ws.rs.*;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

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
@Api(value = "/portfolio", description = "Portfolio", tags = "portfolio")
public class PortfolioEndpoint {

    @Inject
    private Validator validator;

    @Inject
    private PortfolioService portfolioService;

    @GET
    @ApiOperation(value = "Get portfolios", notes = "Pagination system is provided", response = Portfolio[].class)
    public void doGet(
            @BeanParam PaginationParam queryParams,
            @Suspended AsyncResponse asyncResponse
    ) {
        int offset = queryParams.per_page * (queryParams.page - 1);

        final List<Portfolio> portfolios = portfolioService.getPortfolios(offset, queryParams.per_page);
        int total = portfolioService.countPortfolio();

        final Page<Portfolio> paginated =
                new Page<>(
                        portfolios,
                        queryParams.page,
                        queryParams.per_page,
                        total / queryParams.per_page,
                        total);

        asyncResponse.resume(paginated);
    }

    @GET
    @ApiOperation(value = "Get portfolio by key", response = Portfolio.class)
    @Path("{key}")
    public Response doGet(@PathParam("key") String key) {
        Response res = Response.status(Response.Status.NOT_FOUND).build();
        final Optional<Portfolio> portfolio = portfolioService.getPortfolio(new PortfolioKey(key));
        if(portfolio.isPresent()){
            res = Response.ok(portfolio.get()).build();
        }
        return res;
    }

    @POST
    @ApiOperation(value = "Create a portfolio", response = Boolean.class)
    public void doPost(
            @Valid PortfolioParam portfolioParam,
            @Suspended AsyncResponse asyncResponse
    ) {
        final Portfolio portfolio =
                Portfolio.builder()
                        .setKey(new PortfolioKey(portfolioParam.getCode()))
                        .setAmount(portfolioParam.getAmount())
                        .setDevise(portfolioParam.getDevise())
                        .setManager(portfolioParam.getManager());
        asyncResponse.resume(portfolioService.insertPortfolio(portfolio));
    }

    @PUT
    @ApiOperation(value = "Change attribute for a specific portfolio", response = Boolean.class)
    public void doPut(
            @Valid @ConvertGroup(from = Default.class, to = UpdatePortfolio.class) PortfolioParam portfolioParam,
            @Suspended AsyncResponse asyncResponse
    ) {
        final Portfolio portfolio =
                Portfolio.builder()
                        .setKey(new PortfolioKey(portfolioParam.getCode()))
                        .setAmount(portfolioParam.getAmount())
                        .setDevise(portfolioParam.getDevise())
                        .setManager(portfolioParam.getManager());
        asyncResponse.resume(portfolioService.updatePortfolio(portfolio));
    }

    @DELETE
    @ApiOperation(value = "Delete a portfolio", response = Boolean.class)
    @Path("{key}")
    public void doDelete(
            @PathParam("key") String key,
            @Suspended AsyncResponse asyncResponse
    ) {
        asyncResponse.resume(portfolioService.deletePortfolio(new PortfolioKey(key)));
    }
}
