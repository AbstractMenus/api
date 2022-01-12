package ru.abstractmenus.api.variables;

import java.util.Map;

/**
 * Simple cache manager.
 * Uses usually by activators, but can be used by other systems in future
 */
public interface LocalCache {

    /**
     * Get cached value
     * @param scope Cache scope. Any string value, just for prefix
     * @param name Name of cached value
     * @return Cached value or null of not found
     */
    String get(String scope, String name);

    /**
     * Cache some string value. If value by specified scope
     * and name exists, it will be deleted
     * @param scope Cache scope
     * @param name Value name
     * @param value String value
     */
    void cache(String scope, String name, String value);

    /**
     * Cache map of values by some scope.
     * @param scope Cache scope
     * @param values Map with values in name-value format
     */
    void cache(String scope, Map<String, String> values);

    /**
     * Remove cached value
     * @param scope Cache scope
     * @param name Cache name
     */
    void remove(String scope, String name);

}
