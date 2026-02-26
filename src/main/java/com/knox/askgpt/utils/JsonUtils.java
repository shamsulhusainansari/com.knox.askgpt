package com.knox.askgpt.utils;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Type;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class JsonUtils {

    public JsonUtils() {
    }

    static final Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter()).registerTypeAdapter(LocalDateTime.class, new LocalDateTimeTypeAdapter()).registerTypeAdapter(Instant.class, new InstantTypeAdapter()).create();

    /**
     * Converts a JSON string to a Java object.
     *
     * @param <T>        the type of the object
     * @param json       the JSON string
     * @param clazz      the class of the object
     * @return the Java object
     */
    public static <T> T jsonToPojo(String json, Class<T> clazz) {
        return gson.fromJson(json, clazz);
    }

    /**
     * Converts a JSON array string to a Java object.
     *
     * @param <T>        the type of the object
     * @param jsonArray  the JSON array string
     * @param t          the type of the object
     * @return the Java object
     */
    public static <T> T jsonToPojo(String jsonArray, Type t) {
        return gson.fromJson(jsonArray, t);
    }

    /**
     * Converts a Java object to a JSON string.
     *
     * @param <T>        the type of the object
     * @param t          the Java object
     * @return the JSON string
     */
    public static <T> String toJson(T t) {
        return gson.toJson(t);
    }
}

