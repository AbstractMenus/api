package ru.abstractmenus.api.catalog;

import org.bukkit.entity.Player;
import ru.abstractmenus.api.inventory.Menu;

/**
 * Catalog is an objects collection provider
 * Catalog uses in the auto generated menus
 */
public abstract class Catalog {

    /**
     * Create new snapshot instance
     * @param menu Menu in which snapshot will be create
     * @param player Player who open the menu
     * @return New catalog snapshot instance
     */
    public abstract Snapshot<?> snapshot(Player player, Menu menu);

}
