package io.github.mvpotter.rest.model;

import java.util.LinkedList;
import java.util.List;

/**
 * Page container.
 *
 * @param <T> content type
 */
public class Page<T> {

    private final List<T> content;

    public Page() {
        content = new LinkedList<>();
    }

    public List<T> getContent() {
        return content;
    }

}
