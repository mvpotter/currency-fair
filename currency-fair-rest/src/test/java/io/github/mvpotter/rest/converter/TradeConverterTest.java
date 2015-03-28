/*
 * Created with IntelliJ IDEA.
 * User: michaelpotter
 * Date: 28/03/15
 * Time: 14:19
 */
package io.github.mvpotter.rest.converter;

import io.github.mvpotter.TradeTestUtils;
import io.github.mvpotter.rest.model.Trade;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TradeConverterTest {

    private Trade trade;
    private TradeConverter tradeConverter;
    private RestTradeConverter restTradeConverter;

    @Before
    public void before() {
        trade = TradeTestUtils.createTrade();
        tradeConverter = new TradeConverter();
        restTradeConverter = new RestTradeConverter();
    }

    @Test
    public void converterCommutativityTest() {
        io.github.mvpotter.data.model.Trade dataTrade = restTradeConverter.convert(trade);
        final Trade resultTrade = tradeConverter.convert(dataTrade);
        Assert.assertEquals(trade, resultTrade);
    }

}
