/*
 * Created with IntelliJ IDEA.
 * User: michaelpotter
 * Date: 22/03/15
 * Time: 21:42
 */
package io.github.mvpotter.rest.validation.amount;

import io.github.mvpotter.rest.model.Trade;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TradeAmountConsistencyValidator implements ConstraintValidator<TradeAmountConsistencyCheck, Trade> {

    @Override
    public void initialize(TradeAmountConsistencyCheck constraintAnnotation) {

    }

    @Override
    public boolean isValid(final Trade trade, ConstraintValidatorContext context) {
        return trade.getAmountSell().multiply(trade.getRate()).equals(trade.getAmountBuy());
    }

}
