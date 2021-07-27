package ru.nanit.abstractmenus.api.inventory;

import java.util.function.Consumer;

public interface Slot {

    void getSlots(Consumer<Integer> indexCb);

}
