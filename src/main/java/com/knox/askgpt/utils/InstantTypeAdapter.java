package com.knox.askgpt.utils;

import com.google.gson.*;

import java.time.Instant;

public class InstantTypeAdapter implements JsonSerializer<Instant>, JsonDeserializer<Instant> {

    public InstantTypeAdapter() {
    }

    /**
     * Deserializes a JSON element into an Instant object.
     *
     * @param json the JSON element to deserialize
     * @param typeOfT the type of the object to deserialize to
     * @param context the deserialization context
     * @return the deserialized Instant object
     * @throws JsonParseException if an error occurs during deserialization
     */
    @Override
    public Instant deserialize(JsonElement json, java.lang.reflect.Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        return Instant.parse(json.getAsString());
    }

    /**
     * Serializes an Instant object into a JSON element.
     *
     * @param src the Instant object to serialize
     * @param typeOfSrc the type of the object to serialize
     * @param context the serialization context
     * @return the serialized JSON element
     */
    @Override
    public JsonElement serialize(Instant src, java.lang.reflect.Type typeOfSrc, JsonSerializationContext context) {
        return null;
    }
}

