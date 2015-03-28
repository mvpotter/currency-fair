package io.github.mvpotter.rest.api;

import com.fasterxml.jackson.annotation.JsonView;
import io.github.mvpotter.rest.controller.TradeController;
import io.github.mvpotter.rest.model.Trade;
import io.github.mvpotter.rest.model.TradesPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;

/**
 * Trade REST API service.
 */
@Component
@Path("trades")
@Produces(MediaType.APPLICATION_JSON)
public class TradesApi {

    private static final Logger LOGGER = LoggerFactory.getLogger(TradesApi.class);

    private final TradeController tradeController;

    @Context
    private UriInfo uriInfo;

    @Inject
    public TradesApi(final TradeController tradeController) {
        this.tradeController = tradeController;
    }

    @GET
    @JsonView(Trade.View.Public.class)
    public TradesPage getTrades() {
        return tradeController.getTrades();
    }

    @GET
    @Path("{id}")
    public Trade trade(@PathParam("id") final long id) {
        return tradeController.getTrade(id);
    }

    @POST
    public Response saveTrade(@NotNull @Valid final Trade trade) {
        LOGGER.info(trade.toString());
        final Trade savedTrade = tradeController.saveTrade(trade);
        URI location = uriInfo.getAbsolutePathBuilder()
                .path("{id}")
                .resolveTemplate("id", savedTrade.getId())
                .build();
        return Response.created(location).build();
    }

}
