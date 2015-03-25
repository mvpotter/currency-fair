package io.github.mvpotter.rest.api;

import io.github.mvpotter.rest.controller.TradeController;
import io.github.mvpotter.rest.model.CountResponse;
import io.github.mvpotter.rest.model.Trade;
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

@Component
@Path("trade")
@Produces(MediaType.APPLICATION_JSON)
public class TradeApi {

    private static final Logger LOGGER = LoggerFactory.getLogger(TradeApi.class);

    private final TradeController tradeController;

    @Context
    private UriInfo uriInfo;

    @Inject
    public TradeApi(final TradeController tradeController) {
        this.tradeController = tradeController;
    }

    @GET
    @Path("count")
    public CountResponse tradeCount() {
        return new CountResponse(tradeController.getCount());
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
