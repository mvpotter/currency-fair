/*
 * Created with IntelliJ IDEA.
 * User: michaelpotter
 * Date: 22/03/15
 * Time: 13:35
 */
package io.github.mvpotter.rest.controller;

import io.github.mvpotter.rest.model.Trade;

public interface TradeController {

    Trade getTrade(Long id);
    Trade saveTrade(Trade trade);

}
