/*
 * Created with IntelliJ IDEA.
 * User: michaelpotter
 * Date: 22/03/15
 * Time: 14:07
 */
package integration.io.github.mvpotter.rest.api;

import io.github.mvpotter.Application;
import io.github.mvpotter.rest.model.Trade;
import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.net.URI;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest("server.port=9000")
public class TradeApiIntegrationTest {

    private RestTemplate restTemplate = new TestRestTemplate();
    private Trade trade;

    @Before
    public void before() {
        trade = new Trade();
        trade.setUserId(134256);
        trade.setCurrencyFrom("EUR");
        trade.setCurrencyTo("GBP");
        trade.setAmountSell(new BigDecimal("65050"));
        trade.setAmountBuy(new BigDecimal("1000"));
        trade.setRate(new BigDecimal("65.05"));
        trade.setTimePlaced(DateTime.now());
        trade.setOriginatingCountry("RU");
    }

    @Test
    public void saveTradeTest() {

        final URI uri = restTemplate.postForLocation("http://localhost:9000/api/trade", trade);
        final ResponseEntity<Trade> responseEntity = restTemplate.getForEntity(uri, Trade.class);
        final Trade savedTrade = responseEntity.getBody();
        Assert.assertEquals(trade, savedTrade);

    }

}
