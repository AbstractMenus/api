package ru.abstractmenus.api;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Simple storage for context objects that causes menu opening
 */
public final class ActivatorContext {

    private static final Map<UUID, Object> CONTEXT_OBJECTS = new HashMap<>();

    private ActivatorContext() { }

    /**
     * Get current activator context, if exists
     * @param playerId UUID of player who opened menu
     * @return Found context object or null
     */
    public static Object getContext(UUID playerId) {
        return CONTEXT_OBJECTS.get(playerId);
    }

    /**
     * Set current context object
     * @param playerId UUID of player who opened menu
     * @param obj Any Context object
     */
    public static void setContext(UUID playerId, Object obj) {
        CONTEXT_OBJECTS.put(playerId, obj);
    }

    /**
     * Remove context object
     * @param playerId UUID of player
     */
    public static void removeContext(UUID playerId) {
        CONTEXT_OBJECTS.remove(playerId);
    }

}
