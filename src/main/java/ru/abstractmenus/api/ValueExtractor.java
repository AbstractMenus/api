package ru.abstractmenus.api;

/**
 * Implementors of extractor can take some
 * object with placeholder and return required data from this object
 */
public interface ValueExtractor {

    /**
     * Get some data from given object by placeholder
     * @param obj Any object
     * @param placeholder Placeholder like "location_x"
     * @return Resulting value in String format, or null
     */
    String extract(Object obj, String placeholder);

}
