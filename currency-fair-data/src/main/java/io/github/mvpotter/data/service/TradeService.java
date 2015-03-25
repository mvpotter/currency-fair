/*
 * Created with IntelliJ IDEA.
 * User: michaelpotter
 * Date: 22/03/15
 * Time: 10:58
 */
package io.github.mvpotter.data.service;

import io.github.mvpotter.data.model.Trade;
import org.springframework.data.domain.Page;

public interface TradeService {

    long getCount();
    Page<Trade> getTrades();
    Trade getTrade(Long id);
    Trade saveTrade(Trade trade);

}
