package io.github.mvpotter.rest.validation;

import io.github.mvpotter.Application;
import io.github.mvpotter.TradeTestUtils;
import io.github.mvpotter.rest.model.Trade;
import io.github.mvpotter.rest.validation.helper.BeanValidator;
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
        trade = TradeTestUtils.createTrade();
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
