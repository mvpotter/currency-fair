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
    public Trade getTrade(final Long id) {
        return tradeRepository.findOne(id);
    }

    @Override
    public Trade saveTrade(final Trade trade) {
        // TODO: validate
        return tradeRepository.save(trade);
    }

}
