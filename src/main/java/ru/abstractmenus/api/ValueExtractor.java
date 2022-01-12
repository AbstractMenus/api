package ru.abstractmenus.api;

/**
 * Implementors of extractor can take some
 * object with placeholder and return required data from this object
 * @param <T> Type of accepted object
 */
public interface ValueExtractor<T> {

    /**
     * Get some data from given object by placeholder
     * @param obj Any object
     * @param placeholder Placeholder like "location_x"
     * @return Resulting value in String format, or null
     */
    String extract(T obj, String placeholder);

}
