package ru.abstractmenus.api.extractor;

import java.util.HashMap;
import java.util.Map;

/**
 * Value extractors manager
 */
public final class ValueExtractors {

    private static final Map<Class<?>, ValueExtractor<?>> EXTRACTORS = new HashMap<>();

    private ValueExtractors() { }

    /**
     * Get extractor for type
     * @param type Data type class
     * @param <T> Data type
     * @return Found extractor or null
     */
    public static <T> ValueExtractor<T> get(Class<T> type) {
        return (ValueExtractor<T>) EXTRACTORS.get(type);
    }

    /**
     * Register value extractor for some type
     * @param type Data type class
     * @param extractor Extractor instance
     * @param <T> Data type
     */
    public static <T> void register(Class<T> type, ValueExtractor<T> extractor) {
        EXTRACTORS.put(type, extractor);
    }

}
