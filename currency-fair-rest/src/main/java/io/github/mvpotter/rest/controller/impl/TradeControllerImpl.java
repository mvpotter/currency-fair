package io.github.mvpotter.rest.controller.impl;

import io.github.mvpotter.data.service.TradeService;
import io.github.mvpotter.rest.controller.TradeController;
import io.github.mvpotter.rest.model.Trade;
import io.github.mvpotter.rest.model.TradesPage;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;

import javax.inject.Inject;

/**
 * Trade controller implementation.
 */
@Controller
public class TradeControllerImpl implements TradeController {

    private static final int PAGE = 0;
    private static final int PAGE_SIZE = 100;

    private final ConversionService conversionService;
    private final TradeService tradeService;

    @Inject
    public TradeControllerImpl(final ConversionService conversionService, final TradeService tradeService) {
        this.conversionService = conversionService;
        this.tradeService = tradeService;
    }

    @Override
    @SuppressWarnings("unchecked")
    public TradesPage getTrades() {
        return conversionService.convert(tradeService.getTrades(PAGE, PAGE_SIZE), TradesPage.class);
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

}
