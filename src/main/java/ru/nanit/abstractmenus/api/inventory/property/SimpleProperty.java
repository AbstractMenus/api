package ru.nanit.abstractmenus.api.inventory.property;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import ru.nanit.abstractmenus.api.inventory.Menu;

import java.util.Optional;

/**
 * A simple property that can modify ItemStack or item meta
 */
public interface SimpleProperty extends ItemProperty {

    /**
     * Apply property to ItemStack. If return ItemStack, then modified meta won't applied
     * @param itemStack ItemStack object to apply property
     * @param meta ItemStack's metadata
     * @param player Player to replace placeholders
     * @param menu Menu in which this item builds
     * @throws Exception If something wrong while apply property
     * @return ItemStack in Optional wrapper or Optional.EMPTY if nothing to return
     */
    Optional<ItemStack> apply(ItemStack itemStack, ItemMeta meta, Player player, Menu menu) throws Exception;

}
