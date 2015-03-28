package io.github.mvpotter.rest.converter;

import io.github.mvpotter.data.model.Trade;
import io.github.mvpotter.rest.model.TradesPage;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;

/**
 * Converts persistence model entities to REST API once.
 */
public class TradePageConverter implements Converter<Page<Trade>, TradesPage> {

    private final TradeConverter tradeConverter;

    public TradePageConverter() {
        tradeConverter = new TradeConverter();
    }

    @Override
    public TradesPage convert(final Page<Trade> trades) {
        final TradesPage restTrades = new TradesPage(trades.getTotalElements(), trades.getTotalPages(), trades.getSize());
        for (Trade trade: trades) {
            restTrades.getContent().add(tradeConverter.convert(trade));
        }
        return restTrades;
    }

}
