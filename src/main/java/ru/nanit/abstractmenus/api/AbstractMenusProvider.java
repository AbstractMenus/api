package ru.nanit.abstractmenus.api;

public final class AbstractMenusProvider {

    private static AbstractMenusPlugin plugin;

    private AbstractMenusProvider(){}

    public static void init(AbstractMenusPlugin plug){
        plugin = plug;
    }

    public static AbstractMenusPlugin get(){
        return plugin;
    }

}
