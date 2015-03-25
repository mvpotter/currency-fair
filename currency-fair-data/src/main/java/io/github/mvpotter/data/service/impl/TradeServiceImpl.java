/*
 * Created with IntelliJ IDEA.
 * User: michaelpotter
 * Date: 22/03/15
 * Time: 10:50
 */
package io.github.mvpotter.data.service.impl;

import io.github.mvpotter.data.dao.TradeRepository;
import io.github.mvpotter.data.model.Trade;
import io.github.mvpotter.data.service.TradeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class TradeServiceImpl implements TradeService {

    private TradeRepository tradeRepository;

    @Inject
    public TradeServiceImpl(final TradeRepository tradeRepository) {
        this.tradeRepository = tradeRepository;
    }

    @Override
    public Page<Trade> getTrades() {
        return tradeRepository.findAll(new PageRequest(0, 5));
    }

    @Override
    public Trade getTrade(final Long id) {
        return tradeRepository.findOne(id);
    }

    @Override
    public Trade saveTrade(final Trade trade) {
        return tradeRepository.save(trade);
    }

    @Override
    public long getCount() {
        return tradeRepository.count();
    }

}
