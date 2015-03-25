package io.github.mvpotter.rest.configuration;

import io.github.mvpotter.rest.api.RateLimitFilter;
import io.github.mvpotter.rest.api.TradesApi;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.ApplicationPath;

@Configuration
@ApplicationPath("api")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
        register(TradesApi.class);
        register(RateLimitFilter.class);
    }

}