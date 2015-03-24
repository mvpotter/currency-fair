package io.github.mvpotter.rest.api.error;

public final class ErrorHolder {

    private final String error;

    public ErrorHolder(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

}
