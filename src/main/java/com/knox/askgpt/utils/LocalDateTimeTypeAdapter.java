package com.knox.askgpt.utils;

import com.google.gson.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeTypeAdapter implements JsonSerializer<LocalDateTime>, JsonDeserializer<LocalDateTime> {

    public LocalDateTimeTypeAdapter() {
    }

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    /**
     * Deserializes a JsonElement into a LocalDateTime object.
     *
     * @param json the JsonElement to deserialize
     * @param typeOfT the type of the object being deserialized
     * @param context the deserialization context
     * @return the deserialized LocalDateTime object
     * @throws JsonParseException if the deserialization fails
     */
    @Override
    public LocalDateTime deserialize(JsonElement json, java.lang.reflect.Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        return LocalDateTime.parse(json.getAsString(), formatter);
    }

    /**
     * Serializes a LocalDateTime object into a JsonElement.
     *
     * @param date the LocalDateTime object to serialize
     * @param typeOfSrc the type of the object being serialized
     * @param context the serialization context
     * @return the serialized JsonElement
     */
    @Override
    public JsonElement serialize(LocalDateTime date, java.lang.reflect.Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(date.format(formatter));
    }
}

