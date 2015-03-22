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

public class RestTradeConverter implements Converter<io.github.mvpotter.rest.model.Trade, Trade> {

    @Override
    public Trade convert(final io.github.mvpotter.rest.model.Trade restTrade) {
        final Trade trade = new Trade();
        BeanUtils.copyProperties(restTrade, trade);
        return trade;
    }

}
