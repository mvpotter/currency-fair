package io.github.mvpotter.rest.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="api")
public class ApiProperties {

    private int rateLimit;

    public int getRateLimit() {
        return rateLimit;
    }

    public void setRateLimit(final int rateLimit) {
        this.rateLimit = rateLimit;
    }

}
