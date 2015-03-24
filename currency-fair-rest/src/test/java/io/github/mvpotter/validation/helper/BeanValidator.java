/*
 * Created with IntelliJ IDEA.
 * User: michaelpotter
 * Date: 22/03/15
 * Time: 21:01
 */
package io.github.mvpotter.validation.helper;

/**
 * Interface for beans validation.
 */
public interface BeanValidator {

    <T> void validate(T entity);

}
