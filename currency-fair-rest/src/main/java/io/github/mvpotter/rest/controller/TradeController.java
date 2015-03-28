package io.github.mvpotter.rest.controller;

import io.github.mvpotter.rest.model.Trade;
import io.github.mvpotter.rest.model.TradesPage;

/**
 * Trade controller.
 */
public interface TradeController {

    TradesPage getTrades();
    Trade getTrade(Long id);
    Trade saveTrade(Trade trade);

}
