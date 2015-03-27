package io.github.mvpotter.rest.controller;

import io.github.mvpotter.rest.model.Trade;
import io.github.mvpotter.rest.model.TradesPage;

import java.util.List;

public interface TradeController {

    TradesPage getTrades();
    Trade getTrade(Long id);
    Trade saveTrade(Trade trade);

}
