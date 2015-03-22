/*
 * Created with IntelliJ IDEA.
 * User: michaelpotter
 * Date: 22/03/15
 * Time: 13:24
 */
package io.github.mvpotter.rest.converter;

import io.github.mvpotter.data.model.Trade;
import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.converter.Converter;

public class TradeConverter implements Converter<Trade, io.github.mvpotter.rest.model.Trade> {

    @Override
    public io.github.mvpotter.rest.model.Trade convert(final Trade trade) {
        final io.github.mvpotter.rest.model.Trade restTrade = new io.github.mvpotter.rest.model.Trade();
        BeanUtils.copyProperties(trade, restTrade);
        return restTrade;
    }

}
