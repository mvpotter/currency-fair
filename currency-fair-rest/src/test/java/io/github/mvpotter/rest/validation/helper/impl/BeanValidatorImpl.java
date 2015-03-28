/*
 * Created with IntelliJ IDEA.
 * User: michaelpotter
 * Date: 22/03/15
 * Time: 21:03
 */
package io.github.mvpotter.rest.validation.helper.impl;

import io.github.mvpotter.rest.validation.helper.BeanValidator;
import jersey.repackaged.com.google.common.base.Joiner;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.ValidationException;
import javax.validation.Validator;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BeanValidatorImpl implements BeanValidator {

    private Validator validator;

    @Inject
    public BeanValidatorImpl(final Validator validator) {
        this.validator = validator;
    }

    public <T> void validate(final T entity) {
        final Set<ConstraintViolation<T>> constraintViolations = validator.validate(entity);
        if (!constraintViolations.isEmpty()) {
            final Set<String> violationMessages = constraintViolations.stream().map(constraintViolation -> constraintViolation.getPropertyPath() + "="
                    + constraintViolation.getMessageTemplate()).collect(Collectors.toSet());
            throw new ValidationException(Joiner.on("\n").join(violationMessages));
        }
    }

}
