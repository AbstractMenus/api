package ru.abstractmenus.api.variables;

import org.bukkit.entity.Player;

/**
 * Manager for variables. Here you can use CRUD methods to manipulate with variables
 */
public interface VariableManager {

    /**
     * Get global variable
     * @param name Key of variable
     * @return Found variable or null
     */
    Var getGlobal(String name);

    /**
     * Get personal variable
     * @param player Owner if variable
     * @param name Key of variable
     * @return Found variable of null
     */
    Var getPersonal(Player player, String name);

    /**
     * Save variable as global
     * @param var Variable data
     * @param replace If false, then stored variable won't be replaced
     */
    void saveGlobal(Var var, boolean replace);

    /**
     * Create or update variable as personal for some player
     * @param var Variable data
     */
    default void saveGlobal(Var var) {
        saveGlobal(var, true);
    }

    /**
     * Save variable as personal for some player
     * @param var Variable data
     * @param player Variable owner
     * @param replace If false, then stored variable won't be replaced
     */
    void savePersonal(Player player, Var var, boolean replace);

    /**
     * Create or update variable as personal for some player
     * @param var Variable data
     * @param player Variable owner
     */
    default void savePersonal(Player player, Var var) {
        savePersonal(player, var, true);
    }

    /**
     * Delete global variable by name
     * @param name Name of variable
     */
    void deleteGlobal(String name);

    /**
     * Delete personal variable by name and owner
     * @param player Variable owner
     * @param name Name of variable
     */
    void deletePersonal(Player player, String name);

    /**
     * Create builder for variable
     * @return New variable builder
     */
    VarBuilder createBuilder();

}
