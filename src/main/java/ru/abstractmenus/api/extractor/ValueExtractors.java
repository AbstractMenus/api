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
     * @param value Value to get extractor
     * @param <T> Data type
     * @return Found extractor or null
     */
    public static <T> ValueExtractor<T> get(Object value) {
        for (Map.Entry<Class<?>, ValueExtractor<?>> entry : EXTRACTORS.entrySet()) {
            if (entry.getKey().isInstance(value))
                return (ValueExtractor<T>) entry.getValue();
        }
        return null;
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
