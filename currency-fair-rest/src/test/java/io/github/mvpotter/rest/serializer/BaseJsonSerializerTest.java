package io.github.mvpotter.rest.serializer;


import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.io.StringWriter;

public abstract class BaseJsonSerializerTest<T> {

    private JsonSerializer<T> serializer;
    private SerializerProvider serializerProvider;
    private JsonGenerator jsonGenerator;
    private StringWriter stringWriter;

    public void before(final JsonSerializer<T> serializer) throws IOException {
        this.serializer = serializer;
        serializerProvider = new ObjectMapper().getSerializerProvider();
        stringWriter = new StringWriter();
        jsonGenerator = new JsonFactory().createGenerator(stringWriter);
    }

    protected String serialize(T value) throws IOException {
        serializer.serialize(value, jsonGenerator, serializerProvider);
        jsonGenerator.flush();
        return stringWriter.toString();
    }

}
