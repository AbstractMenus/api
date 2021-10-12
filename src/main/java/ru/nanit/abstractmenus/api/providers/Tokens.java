package ru.nanit.abstractmenus.api.providers;

import com.google.common.reflect.TypeToken;
import ninja.leaping.modded.configurate.objectmapping.serialize.TypeSerializer;
import ninja.leaping.modded.configurate.objectmapping.serialize.TypeSerializers;
import ru.nanit.abstractmenus.api.Action;
import ru.nanit.abstractmenus.api.catalog.Catalog;
import ru.nanit.abstractmenus.api.inventory.ItemProperty;
import ru.nanit.abstractmenus.api.Activator;
import ru.nanit.abstractmenus.api.Rule;

import java.util.HashMap;
import java.util.Map;

/**
 * Type tokens provider. All menu data tokens registering here
 */
public final class Tokens {

    private static final Map<String, TypeToken> ACTION_TOKENS = new HashMap<>();
    private static final Map<String, TypeToken> RULE_TOKENS = new HashMap<>();
    private static final Map<String, TypeToken> ACTIVATOR_TOKENS = new HashMap<>();
    private static final Map<String, TypeToken> ITEM_PROPERTIES = new HashMap<>();
    private static final Map<String, TypeToken> CATALOGS = new HashMap<>();

    private Tokens(){}

    /**
     * Register new action
     * @param key Key of the action. This key uses in menu file
     * @param token Type token of the action
     * @param serializer Serializer of the action
     * @param <T> Type of the action
     */
    public static <T> void registerAction(String key, TypeToken<T> token, TypeSerializer<T> serializer){
        TypeSerializers.getDefaultSerializers().registerType(token, serializer);
        ACTION_TOKENS.put(key.toLowerCase(), token);
    }

    /**
     * Get token to deserialize action from menu file
     * @param key Action key
     * @return Found TypeToken of the registered action of null if token not found
     */
    public static TypeToken<? extends Action> getActionType(String key){
        return ACTION_TOKENS.get(key.toLowerCase());
    }

    /**
     * Register new rule
     * @param key Key of the rule. This key uses in menu file
     * @param token Type token of the rule
     * @param serializer Serializer of the rule
     * @param <T> Type of the rule
     */
    public static <T> void registerRule(String key, TypeToken<T> token, TypeSerializer<T> serializer){
        TypeSerializers.getDefaultSerializers().registerType(token, serializer);
        RULE_TOKENS.put(key.toLowerCase(), token);
    }

    /**
     * Get token to deserialize rule from menu file
     * @param key Rule key
     * @return Found TypeToken of the registered rule of null if token not found
     */
    public static TypeToken<? extends Rule> getRuleType(String key){
        return RULE_TOKENS.get(key.toLowerCase());
    }

    /**
     * Register new menu activator
     * @param key Key of the activator. This key uses in menu file
     * @param token Type token of the activator
     * @param serializer Serializer of the activator
     * @param <T> Type of the activator
     */
    public static <T> void registerActivator(String key, TypeToken<T> token, TypeSerializer<T> serializer){
        TypeSerializers.getDefaultSerializers().registerType(token, serializer);
        ACTIVATOR_TOKENS.put(key.toLowerCase(), token);
    }

    /**
     * Get token to deserialize activator from menu file
     * @param key Activator key
     * @return Found TypeToken of the registered activator of null if token not found
     */
    public static TypeToken<? extends Activator> getActivator(String key){
        return ACTIVATOR_TOKENS.get(key.toLowerCase());
    }

    /**
     * Register new item property
     * @param key Key of the property. This key uses in menu file
     * @param token Type token of the property
     * @param serializer Serializer of the property
     * @param <T> Type of the property
     */
    public static <T> void registerItemProperty(String key, TypeToken<T> token, TypeSerializer<T> serializer){
        TypeSerializers.getDefaultSerializers().registerType(token, serializer);
        ITEM_PROPERTIES.put(key.toLowerCase(), token);
    }

    /**
     * Get token to deserialize item property from menu file
     * @param key Item property key
     * @return Found TypeToken of the registered item property of null if token not found
     */
    public static TypeToken<? extends ItemProperty> getItemPropertyType(String key){
        return ITEM_PROPERTIES.get(key.toLowerCase());
    }

    /**
     * Register new catalog
     * @param key Key of the catalog. This key uses in menu file
     * @param token Type token of the catalog
     * @param serializer Serializer of the catalog
     * @param <T> Type of the catalog
     */
    public static <T> void registerCatalog(String key, TypeToken<T> token, TypeSerializer<T> serializer){
        TypeSerializers.getDefaultSerializers().registerType(token, serializer);
        CATALOGS.put(key.toLowerCase(), token);
    }

    /**
     * Get token to deserialize catalog from menu file
     * @param key Catalog key
     * @return Found TypeToken of the registered catalog of null if token not found
     */
    public static TypeToken<? extends Catalog> getCatalogType(String key){
        return CATALOGS.get(key.toLowerCase());
    }
}
