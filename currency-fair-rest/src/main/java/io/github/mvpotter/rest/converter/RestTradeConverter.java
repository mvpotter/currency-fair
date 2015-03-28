package io.github.mvpotter.rest.converter;

import io.github.mvpotter.data.model.Trade;
import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.converter.Converter;

/**
 * Converts REST API entities to persistence model once.
 */
public class RestTradeConverter implements Converter<io.github.mvpotter.rest.model.Trade, Trade> {

    @Override
    public Trade convert(final io.github.mvpotter.rest.model.Trade restTrade) {
        final Trade trade = new Trade();
        BeanUtils.copyProperties(restTrade, trade);
        return trade;
    }

}
