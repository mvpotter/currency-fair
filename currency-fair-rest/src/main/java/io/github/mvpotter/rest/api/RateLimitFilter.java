package io.github.mvpotter.rest.api;

import io.github.mvpotter.rest.api.error.ErrorHolder;
import io.github.mvpotter.rest.configuration.ApiProperties;
import org.apache.commons.lang3.concurrent.TimedSemaphore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.HttpMethod;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * The goal of the filter is to limit the number of POST requests per second.
 */
public class RateLimitFilter implements ContainerRequestFilter {

    public static final int TIME_PERIOD = 1;

    private static final Logger LOGGER = LoggerFactory.getLogger(RateLimitFilter.class);
    private static final String ERROR_QUOTA_EXCEEDED = "Quota exceeded";

    private final TimedSemaphore semaphore;

    @Inject
    public RateLimitFilter(ApiProperties currencyFairProperties) {
        semaphore = new TimedSemaphore(TIME_PERIOD, TimeUnit.SECONDS, currencyFairProperties.getRateLimit());
    }

    @Override
    public void filter(final ContainerRequestContext containerRequestContext) throws IOException {
        if (containerRequestContext.getMethod().equals(HttpMethod.POST) && !hasQuota(semaphore)) {
            rejectRequest(containerRequestContext);
        }
    }

    private boolean hasQuota(final TimedSemaphore semaphore) {
        if (semaphore.getAvailablePermits() > 0) {
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                LOGGER.warn(e.getMessage(), e);
            }

            return true;
        }

        return false;
    }

    private void rejectRequest(final ContainerRequestContext containerRequestContext) {
        final Response response = Response.status(Response.Status.FORBIDDEN)
                .entity(new ErrorHolder(ERROR_QUOTA_EXCEEDED))
                .build();
        containerRequestContext.abortWith(response);
    }

}
