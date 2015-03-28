package io.github.mvpotter.rest.serializer;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;

public class BigDecimalJsonSerializerTest extends BaseJsonSerializerTest<BigDecimal> {

    private static final BigDecimal BIG_DECIMAL_W_TRAILING_ZEROS = new BigDecimal("1.000");
    private static final String BIG_DECIMAL_W_TRAILING_ZEROS_JSON = "1";

    private static final BigDecimal BIG_DECIMAL = new BigDecimal("1.0001");
    private static final String BIG_DECIMAL_JSON = "1.0001";

    @Before
    public void before() throws IOException {
        super.before(new BigDecimalJsonSerializer());
    }

    @Test
    public void bigDecimalWithTrailingZerosSerializationTest() throws IOException {
        Assert.assertEquals(BIG_DECIMAL_W_TRAILING_ZEROS_JSON, serialize(BIG_DECIMAL_W_TRAILING_ZEROS));
    }

    @Test
    public void bigDecimalSerializationTest() throws IOException {
        Assert.assertEquals(BIG_DECIMAL_JSON, serialize(BIG_DECIMAL));
    }

}
