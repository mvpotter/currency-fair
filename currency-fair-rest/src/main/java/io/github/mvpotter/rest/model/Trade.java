package io.github.mvpotter.rest.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.github.mvpotter.rest.serializer.BigDecimalJsonSerializer;
import io.github.mvpotter.rest.serializer.DateTimeJsonDeserializer;
import io.github.mvpotter.rest.serializer.DateTimeJsonSerializer;
import io.github.mvpotter.rest.validation.amount.TradeAmountConsistencyCheck;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.joda.time.DateTime;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@TradeAmountConsistencyCheck
public class Trade {

    public static final String DATE_FORMAT = "dd-MMM-yy HH:mm:ss";

    @JsonView(View.Public.class)
    private Long id;

    @JsonView(View.Internal.class)
    private Long userId;

    @NotNull
    @Size(min = 3, max = 3)
    @JsonView(View.Public.class)
    private String currencyFrom;

    @NotNull
    @Size(min = 3, max = 3)
    @JsonView(View.Public.class)
    private String currencyTo;

    @NotNull
    @Min(0)
    @JsonView(View.Public.class)
    private BigDecimal amountSell;

    @NotNull
    @Min(0)
    @JsonView(View.Public.class)
    private BigDecimal amountBuy;

    @NotNull
    @Min(0)
    @JsonView(View.Public.class)
    @JsonSerialize(using = BigDecimalJsonSerializer.class)
    private BigDecimal rate;

    @NotNull
    @JsonView(View.Public.class)
    @JsonSerialize(using = DateTimeJsonSerializer.class)
    @JsonDeserialize(using = DateTimeJsonDeserializer.class)
    private DateTime timePlaced;

    @NotNull
    @Size(min = 2, max = 2)
    @JsonView(View.Public.class)
    private String originatingCountry;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(final long userId) {
        this.userId = userId;
    }

    public String getCurrencyFrom() {
        return currencyFrom;
    }

    public void setCurrencyFrom(final String currencyFrom) {
        this.currencyFrom = currencyFrom;
    }

    public String getCurrencyTo() {
        return currencyTo;
    }

    public void setCurrencyTo(final String currencyTo) {
        this.currencyTo = currencyTo;
    }

    public BigDecimal getAmountSell() {
        return amountSell;
    }

    public void setAmountSell(final BigDecimal amountSell) {
        this.amountSell = amountSell;
    }

    public BigDecimal getAmountBuy() {
        return amountBuy;
    }

    public void setAmountBuy(final BigDecimal amountBuy) {
        this.amountBuy = amountBuy;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(final BigDecimal rate) {
        this.rate = rate;
    }

    public DateTime getTimePlaced() {
        return timePlaced;
    }

    public void setTimePlaced(final DateTime timePlaced) {
        this.timePlaced = timePlaced;
    }

    public String getOriginatingCountry() {
        return originatingCountry;
    }

    public void setOriginatingCountry(final String originatingCountry) {
        this.originatingCountry = originatingCountry;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) { return false; }
        if (obj == this) { return true; }
        if (obj.getClass() != getClass()) {
            return false;
        }
        final Trade trade = (Trade) obj;
        return new EqualsBuilder()
                .append(currencyFrom, trade.currencyFrom)
                .append(currencyTo, trade.currencyTo)
                .append(amountSell.stripTrailingZeros(), trade.amountSell.stripTrailingZeros())
                .append(amountBuy.stripTrailingZeros(), trade.amountBuy.stripTrailingZeros())
                .append(rate.stripTrailingZeros(), trade.rate.stripTrailingZeros())
                .append(timePlaced.withMillis(0), trade.timePlaced.withMillis(0))
                .append(originatingCountry, trade.originatingCountry)
                .isEquals() && ((id == null || trade.id == null) || id.equals(trade.id));
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(currencyFrom).append(currencyTo)
                .append(amountSell).append(amountBuy)
                .append(rate)
                .append(timePlaced)
                .append(originatingCountry)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "Trade{" +
                "id=" + id +
                ", userId=" + userId +
                ", currencyFrom='" + currencyFrom + '\'' +
                ", currencyTo='" + currencyTo + '\'' +
                ", amountSell=" + amountSell +
                ", amountBuy=" + amountBuy +
                ", rate=" + rate +
                ", timePlaced=" + timePlaced +
                ", originatingCountry='" + originatingCountry + '\'' +
                '}';
    }

    public static class View {
        public interface Public {};
        public interface Internal extends Public {};
    }

}
