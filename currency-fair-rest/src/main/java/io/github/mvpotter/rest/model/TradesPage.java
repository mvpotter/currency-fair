package io.github.mvpotter.rest.model;

import java.util.LinkedList;
import java.util.List;

public class TradesPage extends Page<Trade> {

    private final long total;
    private final long totalPages;
    private final long pageSize;
    private final List<Trade> content;

    public TradesPage(final long total, final long totalPages, final long pageSize) {
        content = new LinkedList<>();
        this.total = total;
        this.totalPages = totalPages;
        this.pageSize = pageSize;
    }

    public long getTotal() {
        return total;
    }

    public long getTotalPages() {
        return totalPages;
    }

    public long getPageSize() {
        return pageSize;
    }

    public List<Trade> getContent() {
        return content;
    }

}
