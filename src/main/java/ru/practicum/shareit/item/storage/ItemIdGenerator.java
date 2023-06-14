package ru.practicum.shareit.item.storage;

public class ItemIdGenerator {
    private static Integer id = 1;

    public static Integer getId() {
        return id++;
    }
}

