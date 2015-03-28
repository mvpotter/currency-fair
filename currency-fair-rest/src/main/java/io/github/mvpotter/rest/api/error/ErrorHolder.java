package io.github.mvpotter.rest.api.error;

/**
 * Holder to keep REST API error response.
 */
public final class ErrorHolder {

    private final String error;

    public ErrorHolder(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

}
