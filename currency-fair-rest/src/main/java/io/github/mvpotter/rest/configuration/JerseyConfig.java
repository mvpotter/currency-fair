package io.github.mvpotter.rest.configuration;

import io.github.mvpotter.rest.api.RateLimitFilter;
import io.github.mvpotter.rest.api.TradeApi;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
        register(TradeApi.class);
        register(RateLimitFilter.class);
    }

}