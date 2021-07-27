package ru.nanit.abstractmenus.api.catalog;

import org.bukkit.entity.Player;
import ru.nanit.abstractmenus.api.inventory.Menu;

import java.util.*;

/**
 * Catalog snapshot represents a frozen collection of objects on the moment when player open menu
 * @param <T> Type of the provided objects
 */
public abstract class Snapshot<T> {

    private final Player player;
    private final Menu menu;

    private ArrayList<T> elements;
    private int pointer = -1;
    private T currentElement;
    private Map<String, String> placeholders;
    private int page;
    private int pages;

    public Snapshot(Player player, Menu menu){
        this.player = player;
        this.menu = menu;
    }

    public Class<T> getType(){
        return (Class<T>) elements.iterator().next().getClass();
    }

    /**
     * Get player (owner) of this snapshot
     * @return Player who opened menu with this snapshot
     */
    public Player getPlayer(){
        return player;
    }

    /**
     * Get menu in which snapshot uses
     * @return Snapshot's menu
     */
    public Menu getMenu() {
        return menu;
    }

    /**
     * Get parsed snapshot elements
     * @return Objects collection
     */
    public Collection<T> getElements(){
        return elements;
    }

    /**
     * Get current pointer of the snapshot
     * @return Pointer of the snapshot
     */
    public int getPointer(){
        return pointer;
    }

    /**
     * Get current element of the snapshot
     * @return Element on which iterator currently stopped
     */
    public T getCurrent(){
        return currentElement;
    }

    /**
     * Iterate to next snapshot element
     * @return true if successful moved cursor or false if has no next element
     */
    public boolean next(){
        if (pointer < elements.size()-1){
            pointer++;
            fetchData();
            return true;
        }
        return false;
    }

    /**
     * Set pointer position
     * @param pointer pointer value
     */
    public void setPointer(int pointer){
        this.pointer = pointer;
    }

    /**
     * Get current page on which snapshot stopped
     * @return Snapshot page
     */
    public int getPage() {
        return page;
    }

    /**
     * Set page of the snapshot. This method updates common menu placeholders
     * @param page Required page
     */
    public void setPage(int page) {
        this.page = page;
        fetchDefault();
    }

    /**
     * Set count of pages of menu in which this snapshot works
     * @param pages Pages count
     */
    public void setPages(int pages){
        this.pages = pages;
    }

    /**
     * Get element by current pointer and generate placeholders
     */
    public void fetchData(){
        currentElement = elements.get(pointer);
        fetchDefault();
        parsePlaceholders(currentElement, placeholders);
    }

    /**
     * Replace generated placeholders in single string
     * @param placeholder Required placeholder to replace
     * @return String with replaced placeholders
     */
    public String replace(String placeholder){
        if (placeholder == null) return null;
        return placeholders.get(placeholder);
    }

    /**
     * Parse elements, specified to snapshot type
     */
    public void parse(){
        this.elements = new ArrayList<>(parseElements());
    }

    /**
     * Generate objects for this snapshot.
     * @return Collection of snapshot objects.
     */
    public abstract Collection<T> parseElements();

    /**
     * Assign placeholders by provided element of parsed collection and placeholders map.
     * @param element Current element of the collection.
     * @param map Map for placeholders.
     *            Key of map is a placeholder name without brackets.
     *            Value of map is a value to replace placeholders.
     */
    public abstract void parsePlaceholders(T element, Map<String, String> map);

    private void fetchDefault(){
        if (placeholders == null) placeholders = new HashMap<>();
        addDefaultPlaceholders(placeholders);
    }

    private void addDefaultPlaceholders(Map<String, String> map){
        map.put("page", String.valueOf(page+1));
        map.put("pages", String.valueOf(pages));
        map.put("page_next", String.valueOf(page+2));
        map.put("page_prev", String.valueOf(page));
        map.put("elements", String.valueOf(elements.size()));
    }

}