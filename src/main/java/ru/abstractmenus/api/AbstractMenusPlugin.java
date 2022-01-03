package ru.abstractmenus.api;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import ru.abstractmenus.api.inventory.Menu;

/**
 * Base plugin interface
 */
public interface AbstractMenusPlugin {

    /**
     * Get plugin instance
     * @return Plugin instance
     */
    Plugin getPlugin();

    /**
     * Reload all menus
     */
    void loadMenus();

    /**
     * Open menu for a player
     * @param player Menu viewer
     * @param menu Menu to open
     */
    void openMenu(Player player, Menu menu);

}
