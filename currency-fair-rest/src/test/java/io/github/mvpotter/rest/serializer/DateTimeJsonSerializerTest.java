package io.github.mvpotter.rest.serializer;


import io.github.mvpotter.rest.model.Trade;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class DateTimeJsonSerializerTest extends BaseJsonSerializerTest<DateTime> {

    private static final DateTime DATE_TIME = DateTime.now();
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormat.forPattern(Trade.DATE_FORMAT);
    private static final String DATE_TIME_JSON = DATE_TIME.toString(DATE_TIME_FORMATTER);


    @Before
    public void before() throws IOException {
        super.before(new DateTimeJsonSerializer());
    }

    @Test
    public void dateTimeSerializationTest() throws IOException {
        Assert.assertEquals("\"" + DATE_TIME_JSON.toUpperCase() + "\"", serialize(DATE_TIME));
    }

}
