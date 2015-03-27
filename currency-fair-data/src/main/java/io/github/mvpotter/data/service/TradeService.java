package io.github.mvpotter.data.service;

import io.github.mvpotter.data.model.Trade;
import org.springframework.data.domain.Page;

public interface TradeService {

    Page<Trade> getTrades(int page, int size);
    Trade getTrade(Long id);
    Trade saveTrade(Trade trade);

}
