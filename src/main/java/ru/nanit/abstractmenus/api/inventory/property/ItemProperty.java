package ru.nanit.abstractmenus.api.inventory.property;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import ru.nanit.abstractmenus.api.inventory.Menu;

/**
 * Represent any item property
 */
public interface ItemProperty {

    /**
     * Apply property to ItemStack
     * @param item Source ItemStack
     * @param meta Current meta of this item
     * @param player Player for who this item builds
     * @param menu Menu which cause item building
     * @return true if modified ItemMeta should be applied to item after exiting this method, or false if item
     * modified manually and saved ItemMeta shouldn't be assigned after exiting this method
     */
    boolean apply(ItemStack item, ItemMeta meta, Player player, Menu menu);

}
