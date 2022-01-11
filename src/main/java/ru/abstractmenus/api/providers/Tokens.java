package ru.abstractmenus.api.providers;

import ru.abstractmenus.api.Action;
import ru.abstractmenus.api.Activator;
import ru.abstractmenus.api.Rule;
import ru.abstractmenus.api.inventory.ItemProperty;
import ru.abstractmenus.hocon.api.serialize.NodeSerializer;
import ru.abstractmenus.hocon.api.serialize.NodeSerializers;
import ru.abstractmenus.api.catalog.Catalog;

import java.util.HashMap;
import java.util.Map;

/**
 * Types provider. All data types for menus registering here
 */
public final class Tokens {

    private static final Map<String, Class<? extends Action>> ACTION_TOKENS = new HashMap<>();
    private static final Map<String, Class<? extends Rule>> RULE_TOKENS = new HashMap<>();
    private static final Map<String, Class<? extends Activator>> ACTIVATOR_TOKENS = new HashMap<>();
    private static final Map<String, Class<? extends ItemProperty>> ITEM_PROPERTIES = new HashMap<>();
    private static final Map<String, Class<? extends Catalog>> CATALOGS = new HashMap<>();

    /**
     * Global serializers collection
     */
    public static final NodeSerializers SERIALIZERS = NodeSerializers.defaults();

    private Tokens(){}

    /**
     * Register new action
     * @param key Key of the action. This key uses in menu file
     * @param token Type of the action
     * @param serializer Serializer of the action
     * @param <T> Type of the action
     */
    public static <T extends Action> void registerAction(String key, Class<T> token, NodeSerializer<T> serializer){
        SERIALIZERS.register(token, serializer);
        ACTION_TOKENS.put(key.toLowerCase(), token);
    }

    /**
     * Get token to deserialize action from menu file
     * @param key Action key
     * @return Found TypeToken of the registered action of null if token not found
     */
    public static Class<? extends Action> getActionType(String key){
        return ACTION_TOKENS.get(key.toLowerCase());
    }

    /**
     * Register new rule
     * @param key Key of the rule. This key uses in menu file
     * @param token Type of the rule
     * @param serializer Serializer of the rule
     * @param <T> Type of the rule
     */
    public static <T extends Rule> void registerRule(String key, Class<T> token, NodeSerializer<T> serializer){
        SERIALIZERS.register(token, serializer);
        RULE_TOKENS.put(key.toLowerCase(), token);
    }

    /**
     * Get token to deserialize rule from menu file
     * @param key Rule key
     * @return Found TypeToken of the registered rule of null if token not found
     */
    public static Class<? extends Rule> getRuleType(String key){
        return RULE_TOKENS.get(key.toLowerCase());
    }

    /**
     * Register new menu activator
     * @param key Key of the activator. This key uses in menu file
     * @param token Type of the activator
     * @param serializer Serializer of the activator
     * @param <T> Type of the activator
     */
    public static <T extends Activator> void registerActivator(String key, Class<T> token, NodeSerializer<T> serializer){
        SERIALIZERS.register(token, serializer);
        ACTIVATOR_TOKENS.put(key.toLowerCase(), token);
    }

    /**
     * Get token to deserialize activator from menu file
     * @param key Activator key
     * @return Found TypeToken of the registered activator of null if token not found
     */
    public static Class<? extends Activator> getActivator(String key){
        return ACTIVATOR_TOKENS.get(key.toLowerCase());
    }

    /**
     * Register new item property
     * @param key Key of the property. This key uses in menu file
     * @param token Type of the property
     * @param serializer Serializer of the property
     * @param <T> Type of the property
     */
    public static <T extends ItemProperty> void registerItemProperty(String key, Class<T> token, NodeSerializer<T> serializer){
        SERIALIZERS.register(token, serializer);
        ITEM_PROPERTIES.put(key.toLowerCase(), token);
    }

    /**
     * Get token to deserialize item property from menu file
     * @param key Item property key
     * @return Found TypeToken of the registered item property of null if token not found
     */
    public static Class<? extends ItemProperty> getItemPropertyType(String key){
        return ITEM_PROPERTIES.get(key.toLowerCase());
    }

    /**
     * Register new catalog
     * @param key Key of the catalog. This key uses in menu file
     * @param token Type of the catalog
     * @param serializer Serializer of the catalog
     * @param <T> Type of the catalog
     */
    public static <T extends Catalog> void registerCatalog(String key, Class<T> token, NodeSerializer<T> serializer){
        SERIALIZERS.register(token, serializer);
        CATALOGS.put(key.toLowerCase(), token);
    }

    /**
     * Get token to deserialize catalog from menu file
     * @param key Catalog key
     * @return Found TypeToken of the registered catalog of null if token not found
     */
    public static Class<? extends Catalog> getCatalogType(String key){
        return CATALOGS.get(key.toLowerCase());
    }
}
