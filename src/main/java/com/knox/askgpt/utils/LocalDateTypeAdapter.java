package com.knox.askgpt.utils;

import com.google.gson.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateTypeAdapter implements JsonSerializer<LocalDate>, JsonDeserializer<LocalDate> {

    public LocalDateTypeAdapter() {
    }

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    /**
     * Deserializes a JSON element into a LocalDate object.
     *
     * @param json the JSON element to deserialize
     * @param typeOfT the type of the object being deserialized
     * @param context the deserialization context
     * @return the deserialized LocalDate object
     * @throws JsonParseException if the JSON element cannot be deserialized
     */
    @Override
    public LocalDate deserialize(JsonElement json, java.lang.reflect.Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        return LocalDate.parse(json.getAsString(), formatter);
    }

    /**
     * Serializes a LocalDate object into a JSON element.
     *
     * @param date the LocalDate object to serialize
     * @param typeOfSrc the type of the object being serialized
     * @param context the serialization context
     * @return the serialized JSON element
     */
    @Override
    public JsonElement serialize(LocalDate date, java.lang.reflect.Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(date.format(formatter));
    }
}

