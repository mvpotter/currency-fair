package io.github.mvpotter.rest.configuration;

import io.github.mvpotter.rest.api.TradeApi;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(TradeApi.class);
    }

}