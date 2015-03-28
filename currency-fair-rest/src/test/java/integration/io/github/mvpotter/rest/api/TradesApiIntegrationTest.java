package integration.io.github.mvpotter.rest.api;

import io.github.mvpotter.Application;
import io.github.mvpotter.TradeTestUtils;
import io.github.mvpotter.rest.model.Trade;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest("server.port=9000")
public class TradesApiIntegrationTest {

    private RestTemplate restTemplate = new TestRestTemplate();
    private Trade trade;

    @Before
    public void before() {
        trade = TradeTestUtils.createTrade();
    }

    @Test
    public void saveTradeTest() {

        final URI uri = restTemplate.postForLocation("http://localhost:9000/api/trades", trade);
        final ResponseEntity<Trade> responseEntity = restTemplate.getForEntity(uri, Trade.class);
        final Trade savedTrade = responseEntity.getBody();
        Assert.assertEquals(trade, savedTrade);

    }

}
