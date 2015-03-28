package io.github.mvpotter.rest.serializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import io.github.mvpotter.rest.model.Trade;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.io.IOException;

/**
 * DateTime json deserializer.
 */
public class DateTimeJsonDeserializer extends JsonDeserializer<DateTime> {

    @Override
    public DateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException {
        DateTimeFormatter format = DateTimeFormat.forPattern(Trade.DATE_FORMAT);
        return format.parseDateTime(jsonParser.getText());
    }

}
