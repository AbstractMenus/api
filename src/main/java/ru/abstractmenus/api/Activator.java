package ru.abstractmenus.api;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import ru.abstractmenus.api.inventory.Menu;

import java.util.HashMap;
import java.util.Map;

/**
 * Menu activator. Activator will be registered as event listener.
 * Do not register it manually, plugin does this automatically
 */
public abstract class Activator implements Listener {

    public static final String CACHE_SCOPE = "activators";

    /**
     * Menu instance
     */
    protected Menu menu;
    private String name;

    /**
     * Set menu to this activator
     * @param menu Target menu
     */
    public void setTargetMenu(Menu menu) {
        this.menu = menu;
    }

    /**
     * Local method to set activator name when activator parsed.
     * You shouldn't call this method.
     * This needed for AM backed to save activator name in placeholder
     * @param name Activator name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Open menu for a player
     * @param ctx Opening context. This can be Bukkit Event or something else
     * @param player Player to open menu
     * @param <T> Context type
     */
    protected <T> void openMenu(T ctx, Player player) {
        AbstractMenusPlugin plugin = AbstractMenusProvider.get();
        Map<String, String> vars = new HashMap<>();
        vars.put("name", name);
        cache(ctx, vars);
        plugin.getVariableManager().cache()
                .cache(CACHE_SCOPE, vars);
        plugin.openMenu(player, menu);
    }

    /**
     * Cache some specific for activator variables before menu opening.
     * Variable lives only while menu opened.
     * These variables will be available by placeholders.
     * @param ctx Opening context. You need to cast it manually to context what you need.
     *            In many cases you need to cast it to Bukkit Event you used to open menu.
     * @param vars Variables map
     * @param <T> Context type
     */
    protected <T> void cache(T ctx, Map<String, String> vars) { }

}
