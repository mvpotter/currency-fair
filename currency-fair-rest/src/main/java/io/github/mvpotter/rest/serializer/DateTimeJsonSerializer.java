package io.github.mvpotter.rest.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import io.github.mvpotter.rest.model.Trade;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.io.IOException;

/**
 * DateTime json serializer.
 */
public class DateTimeJsonSerializer extends JsonSerializer<DateTime> {

    @Override
    public void serialize(DateTime dateTime, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
            throws IOException {
        DateTimeFormatter format = DateTimeFormat.forPattern(Trade.DATE_FORMAT);
        jsonGenerator.writeString(dateTime.toString(format).toUpperCase());
    }
}
