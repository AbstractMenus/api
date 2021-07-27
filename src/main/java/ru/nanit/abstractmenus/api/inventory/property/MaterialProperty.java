package ru.nanit.abstractmenus.api.inventory.property;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import ru.nanit.abstractmenus.api.inventory.Menu;

import java.util.Optional;

/**
 * A property which can set a default look
 * of item with material and other params
 */
public interface MaterialProperty extends ItemProperty {

    /**
     * Get ItemStack with required material
     * @param player Player to replace placeholders
     * @param menu Menu in which item builds
     * @return Built ItemStack
     * @throws Exception If something wring while build ItemStack
     */
    ItemStack getItem(Player player, Menu menu) throws Exception;

}
