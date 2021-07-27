package ru.nanit.abstractmenus.api.inventory;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.*;
import ru.nanit.abstractmenus.api.Logger;
import ru.nanit.abstractmenus.api.inventory.property.ItemProperty;
import ru.nanit.abstractmenus.api.inventory.property.MaterialProperty;
import ru.nanit.abstractmenus.api.inventory.property.SimpleProperty;

import java.util.*;

/**
 * Represent buildable ItemStack
 */
public class Item implements Cloneable {

    private Map<String, ItemProperty> properties;

    public Item(){}

    public Item(Map<String, ItemProperty> properties){
        this.properties = properties;
    }

    public Item(Item item){
        this(item.getProperties());
    }

    /**
     * Get properties if the item
     * @return List of item properties
     */
    public Map<String, ItemProperty> getProperties(){
        return properties;
    }

    /**
     * Add some property for this item
     * @param property Item property
     */
    public void addProperty(String key, ItemProperty property){
        if (properties == null) properties = new HashMap<>();
        properties.put(key.toLowerCase(), property);
    }

    /**
     * Remove property from item
     * @param key Key (name) of the property. This key you specify in item block in menu file
     * @return Removed property or null if property with specified key is not assigned to item
     */
    public ItemProperty removeProperty(String key){
        return properties.remove(key.toLowerCase());
    }

    /**
     * Build ItemStack of this item
     * @param player Player to correct replace all placeholders
     * @param menu Menu in which this item exists. Might be null
     * @return Built ItemStack object
     */
    public ItemStack build(Player player, Menu menu){
        try{
            ItemStack item = null;

            // Apply material property first
            for (ItemProperty property : properties.values()){
                if (property instanceof MaterialProperty){
                    item = ((MaterialProperty)property).getItem(player, menu);
                    break;
                }
            }

            if (item == null){
                throw new IllegalArgumentException("Item has not any material data");
            }

            // Apply simple properties
            for (ItemProperty property : properties.values()){
                if (property instanceof SimpleProperty){
                    ItemMeta meta = item.getItemMeta();
                    Optional<ItemStack> stack = ((SimpleProperty)property).apply(item, meta, player, menu);

                    if (stack.isPresent()){
                        item = stack.get();
                    } else {
                        item.setItemMeta(meta);
                    }
                }
            }

            return item;
        } catch (Exception e){
            Logger.warning("Error while building ItemStack: " + e.getMessage());
        }

        return null;
    }

    /**
     * Check is this item similar to som ItemStack
     * @param item Bukkit ItemStack
     * @param player Player to replace placeholders
     * @return true if this item similar to provided or false otherwise
     */
    public boolean isSimilar(ItemStack item, Player player){
        if (item == null) return false;
        return item.isSimilar(build(player, null));
    }

    @Override
    public Item clone() {
        try{
            Item item = (Item) super.clone();
            item.properties = new HashMap<>(item.properties);
            return item;
        } catch (CloneNotSupportedException e){
            return null;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Item){
            return Objects.equals(this.properties, ((Item) o).properties);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.properties);
    }

    @Override
    public String toString(){
        return "Item:{properties: "+properties+"}";
    }
}
