/*
 * Created with IntelliJ IDEA.
 * User: michaelpotter
 * Date: 22/03/15
 * Time: 10:58
 */
package io.github.mvpotter.data.service;

import io.github.mvpotter.data.model.Trade;

public interface TradeService {

    Trade getTrade(Long id);
    Trade saveTrade(Trade trade);
    long getCount();

}
