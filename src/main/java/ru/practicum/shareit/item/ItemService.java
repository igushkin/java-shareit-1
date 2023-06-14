package ru.practicum.shareit.item;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.practicum.shareit.item.storage.ItemStorage;
import ru.practicum.shareit.user.storage.UserStorage;

import java.util.List;

@Service
public class ItemService {

    private final ItemStorage itemStorage;
    private final UserStorage userStorage;

    @Autowired
    public ItemService(ItemStorage itemStorage, UserStorage userStorage) {
        this.itemStorage = itemStorage;
        this.userStorage = userStorage;
    }

    public Item getItemById(Integer id) {
        return itemStorage.getItemById(id);
    }

    public List<Item> getAllByUserId(Integer userId) {
        return itemStorage.getItemsByUserId(userId);
    }

    public List<Item> findItemByText(String text) {
        text = text.trim().toLowerCase();

        if (Strings.isBlank(text)) {
            return List.of();
        }

        return itemStorage.findAvailableItemsByText(text);
    }

    public Item createItem(Integer userId, Item item) {
        var owner = userStorage.getUserById(userId);
        item.setOwner(owner);
        return itemStorage.createItem(item);
    }

    public Item patchItem(Item item, Integer itemId, Integer userId) {
        var owner = userStorage.getUserById(userId);
        item.setOwner(owner);
        return itemStorage.patchItem(item, itemId);
    }
}
