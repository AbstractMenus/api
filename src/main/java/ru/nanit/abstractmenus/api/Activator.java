package ru.nanit.abstractmenus.api;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import ru.nanit.abstractmenus.api.inventory.Menu;

/**
 * Menu activator. Activator must be registered as event listener
 */
public abstract class Activator implements Listener {

    protected Menu menu;

    /**
     * Set menu to this activator
     * @param menu Target menu
     */
    public void setTargetMenu(Menu menu){
        this.menu = menu;
    }

    protected void openMenu(Player player){
        AbstractMenusProvider.get().openMenu(player, menu);
    }

}
