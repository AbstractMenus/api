package ru.abstractmenus.api.variables;

import java.util.Map;

/**
 * Simple cache manager.
 * Uses usually by activators, but can be used by other systems in future
 */
public interface LocalCache {

    /**
     * Get cached value
     * @param username Name of player
     * @param scope Cache scope. Any string value, just for prefix
     * @param name Name of cached value
     * @return Cached value or null of not found
     */
    String get(String username, String scope, String name);

    /**
     * Get all cached values by user and scope
     * @param username Name of player
     * @param scope Cache scope. Any string value, just for prefix
     * @return Cached value or null of not found
     */
    Map<String, String> get(String username, String scope);

    /**
     * Cache some string value. If value by specified scope
     * and name exists, it will be deleted
     * @param username Name of player
     * @param scope Cache scope
     * @param name Value name
     * @param value String value
     */
    void cache(String username, String scope, String name, String value);

    /**
     * Cache map of values by some scope.
     * @param username Name of player
     * @param scope Cache scope
     * @param values Map with values in name-value format
     */
    void cache(String username, String scope, Map<String, String> values);

    /**
     * Remove cached value
     * @param username Name of player
     * @param scope Cache scope
     * @param name Cache name
     */
    void remove(String username, String scope, String name);

}
