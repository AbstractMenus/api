package ru.abstractmenus.api;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import ru.abstractmenus.api.inventory.Menu;
import ru.abstractmenus.api.variables.VariableManager;

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
     * Get variables manager
     * @return Variables manager instance
     */
    VariableManager getVariableManager();

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
