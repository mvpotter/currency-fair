/*
 * Created with IntelliJ IDEA.
 * User: michaelpotter
 * Date: 22/03/15
 * Time: 13:35
 */
package io.github.mvpotter.rest.controller;

import io.github.mvpotter.rest.model.Trade;

import java.util.List;

public interface TradeController {

    List<Trade> getTrades();
    long getCount();
    Trade getTrade(Long id);
    Trade saveTrade(Trade trade);

}
