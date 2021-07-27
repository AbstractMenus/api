package ru.nanit.abstractmenus.api;

import org.bukkit.entity.Player;
import ru.nanit.abstractmenus.api.inventory.Menu;
import ru.nanit.abstractmenus.api.inventory.Item;

/**
 * Represents menu action.
 */
@FunctionalInterface
public interface Action {

    /**
     * Do action by provided data
     * @param player Player who initiated this action
     * @param menu Menu in which this action initiated
     * @param clickedItem Item which initiated this action. Might be null
     */
    void activate(Player player, Menu menu, Item clickedItem);

}
