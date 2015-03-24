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
        if (trade.getAmountSell() == null || trade.getAmountBuy() == null || trade.getRate() == null) {
            return false;
        }
        return trade.getAmountSell().multiply(trade.getRate()).stripTrailingZeros()
                .equals(trade.getAmountBuy().stripTrailingZeros());
    }

}
