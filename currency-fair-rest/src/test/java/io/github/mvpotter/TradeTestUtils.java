/*
 * Created with IntelliJ IDEA.
 * User: michaelpotter
 * Date: 28/03/15
 * Time: 14:21
 */
package io.github.mvpotter;

import io.github.mvpotter.rest.model.Trade;
import org.apache.commons.lang3.RandomStringUtils;
import org.joda.time.DateTime;

import java.math.BigDecimal;

public final class TradeTestUtils {

    private TradeTestUtils() {
        throw new UnsupportedOperationException("Unable to create instance of static class");
    }

    public static Trade createTrade() {
        final Trade trade = new Trade();

        trade.setUserId(Long.valueOf(RandomStringUtils.randomNumeric(6)));
        trade.setCurrencyFrom(RandomStringUtils.randomAlphabetic(3));
        trade.setCurrencyTo(RandomStringUtils.randomAlphabetic(3));

        final BigDecimal sell = new BigDecimal(RandomStringUtils.randomNumeric(5));
        final BigDecimal rate = new BigDecimal(RandomStringUtils.randomNumeric(2));
        trade.setAmountSell(sell);
        trade.setAmountBuy(sell.multiply(rate));
        trade.setRate(rate);
        trade.setTimePlaced(DateTime.now());
        trade.setOriginatingCountry(RandomStringUtils.randomAlphabetic(2));

        return trade;
    }

}
