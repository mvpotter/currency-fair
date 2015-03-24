/*
 * Created with IntelliJ IDEA.
 * User: michaelpotter
 * Date: 23/03/15
 * Time: 19:06
 */
package io.github.mvpotter.validation;

import io.github.mvpotter.Application;
import io.github.mvpotter.rest.model.Trade;
import io.github.mvpotter.validation.helper.BeanValidator;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import javax.validation.ValidationException;
import java.math.BigDecimal;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
public class TradeValidationTest {

    @Inject
    private BeanValidator beanValidator;

    private Trade trade;

    @Before
    public void before() {
        trade = new Trade();
        trade.setUserId(134256);
        trade.setCurrencyFrom("EUR");
        trade.setCurrencyTo("RUB");
        trade.setAmountSell(new BigDecimal("2000"));
        trade.setAmountBuy(new BigDecimal("130100"));
        trade.setRate(new BigDecimal("65.05"));
        trade.setTimePlaced(DateTime.now());
        trade.setOriginatingCountry("RU");
    }

    @Test
    public void successTest() {
        beanValidator.validate(trade);
    }

    @Test(expected = ValidationException.class)
    public void incorrectCurrencyFromTest() {
        trade.setCurrencyFrom("ru");
        beanValidator.validate(trade);
    }

    @Test(expected = ValidationException.class)
    public void incorrectCurrencyToTest() {
        trade.setCurrencyFrom("EURO");
        beanValidator.validate(trade);
    }

    @Test(expected = ValidationException.class)
    public void incorrectSellAmountTest() {
        trade.setAmountSell(BigDecimal.ONE.negate());
        beanValidator.validate(trade);
    }

    @Test(expected = ValidationException.class)
    public void incorrectRateAmountTest() {
        trade.setAmountBuy(BigDecimal.ONE.negate());
        beanValidator.validate(trade);
    }

    @Test(expected = ValidationException.class)
    public void inconsistentAmountTest() {
        trade.setAmountBuy(BigDecimal.ONE);
        beanValidator.validate(trade);
    }

    @Test(expected = ValidationException.class)
    public void incorrectOriginatingCountryTest() {
        trade.setOriginatingCountry("RUS");
        beanValidator.validate(trade);
    }

}
