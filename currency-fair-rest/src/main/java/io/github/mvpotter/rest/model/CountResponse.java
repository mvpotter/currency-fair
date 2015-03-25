package io.github.mvpotter.rest.model;

public final class CountResponse {

    final long count;

    public CountResponse(final long count) {
        this.count = count;
    }

    public long getCount() {
        return count;
    }

}
