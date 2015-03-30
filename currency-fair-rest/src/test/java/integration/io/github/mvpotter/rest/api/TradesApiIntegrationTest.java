package integration.io.github.mvpotter.rest.api;

import io.github.mvpotter.Application;
import io.github.mvpotter.TradeTestUtils;
import io.github.mvpotter.rest.model.Trade;
import org.apache.commons.codec.binary.Base64;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest("server.port=9000")
public class TradesApiIntegrationTest {

    private RestTemplate restTemplate = new TestRestTemplate();
    private Trade trade;
    private String base64Credentials;

    @Before
    public void before() {
        trade = TradeTestUtils.createTrade();
        String credentials = "test:test";
        base64Credentials = new String(Base64.encodeBase64(credentials.getBytes()));
    }

    @Test
    public void saveTradeTest() {

        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.set("Authorization", "Basic " + base64Credentials);
        HttpEntity<Trade> httpEntity = new HttpEntity<>(trade, requestHeaders);
        final URI uri = restTemplate.postForLocation("http://localhost:9000/api/trades", httpEntity);
        final ResponseEntity<Trade> responseEntity = restTemplate.getForEntity(uri, Trade.class);
        final Trade savedTrade = responseEntity.getBody();
        Assert.assertEquals(trade, savedTrade);

    }

    @Test(expected = UnauthorizedError.class)
    public void saveTradeUnauthorizedTest() {

        restTemplate.setErrorHandler(new ResponseErrorHandler() {
            @Override
            public boolean hasError(ClientHttpResponse response) throws IOException {
                return true;
            }

            @Override
            public void handleError(ClientHttpResponse response) throws IOException {
                if(HttpStatus.UNAUTHORIZED.value() == response.getRawStatusCode()) {
                    throw new UnauthorizedError();
                }
            }
        });
        restTemplate.postForLocation("http://localhost:9000/api/trades", trade);


    }

    private class UnauthorizedError extends RuntimeException {

    }

}
