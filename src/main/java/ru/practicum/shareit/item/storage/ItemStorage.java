package ru.practicum.shareit.item.storage;

import ru.practicum.shareit.item.Item;

import java.util.List;

public interface ItemStorage {
    Item getItemById(Integer id);

    List<Item> getItemsByUserId(Integer userId);

    List<Item> findAvailableItemsByText(String text);

    Item createItem(Item item);

    Item patchItem(Item item, Integer itemId);
}
