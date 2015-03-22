/*
* Created with IntelliJ IDEA.
* User: michaelpotter
* Date: 22/03/15
* Time: 21:37
*/
package io.github.mvpotter.rest.validation.amount;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

@Target({TYPE, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = TradeAmountConsistencyValidator.class)
@Documented
public @interface TradeAmountConsistencyCheck {

    String message() default "{io.github.mvpotter.constraints.amountconsistency}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}