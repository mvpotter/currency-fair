/*
 * Created with IntelliJ IDEA.
 * User: michaelpotter
 * Date: 22/03/15
 * Time: 13:33
 */
package io.github.mvpotter.rest.controller.impl;

import io.github.mvpotter.data.service.TradeService;
import io.github.mvpotter.rest.controller.TradeController;
import io.github.mvpotter.rest.model.Trade;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;

import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;

@Controller
public class TradeControllerImpl implements TradeController {

    private final ConversionService conversionService;
    private final TradeService tradeService;

    @Inject
    public TradeControllerImpl(final ConversionService conversionService, final TradeService tradeService) {
        this.conversionService = conversionService;
        this.tradeService = tradeService;
    }

    @Override
    public List<Trade> getTrades() {
        // TODO: move to converter
        final List<Trade> trades = new LinkedList<>();
        for (io.github.mvpotter.data.model.Trade trade: tradeService.getTrades()) {
            trades.add(conversionService.convert(trade, Trade.class));
        }
        return trades;
    }

    @Override
    public Trade getTrade(final Long id) {
        final io.github.mvpotter.data.model.Trade trade = tradeService.getTrade(id);
        return conversionService.convert(trade, Trade.class);
    }

    @Override
    public Trade saveTrade(final Trade restTrade) {
        final io.github.mvpotter.data.model.Trade trade
                = conversionService.convert(restTrade, io.github.mvpotter.data.model.Trade.class);
        final io.github.mvpotter.data.model.Trade savedTrade = tradeService.saveTrade(trade);
        return conversionService.convert(savedTrade, Trade.class);
    }

    @Override
    public long getCount() {
        return tradeService.getCount();
    }

}
