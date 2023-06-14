package ru.practicum.shareit.item.storage;

import org.springframework.stereotype.Component;
import ru.practicum.shareit.item.Item;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class InMemoryItemStorage implements ItemStorage {
    private final Map<Integer, Item> itemStorage;

    public InMemoryItemStorage() {
        this.itemStorage = new HashMap<>();
    }

    @Override
    public Item getItemById(Integer id) {
        return itemStorage.get(id);
    }

    @Override
    public List<Item> getItemsByUserId(Integer userId) {
        return itemStorage.values()
                .stream()
                .filter(x -> x.getOwner().getId().equals(userId))
                .collect(Collectors.toList());
    }

    @Override
    public List<Item> findAvailableItemsByText(String text) {
        return itemStorage.values()
                .stream()
                .filter(x -> x.getAvailable())
                .filter(x -> x.getName().toLowerCase().contains(text) || x.getDescription().toLowerCase().contains(text))
                .collect(Collectors.toList());
    }

    @Override
    public Item createItem(Item item) {
        validateCreation(item);
        item.setId(ItemIdGenerator.getId());
        itemStorage.put(item.getId(), item);
        return item;
    }

    @Override
    public Item patchItem(Item item, Integer itemId) {
        var originalItem = getItemById(itemId);
        validatePatch(originalItem, item);

        if (item.getAvailable() != null) {
            originalItem.setAvailable(item.getAvailable());
        }
        if (item.getName() != null) {
            originalItem.setName(item.getName());
        }
        if (item.getDescription() != null) {
            originalItem.setDescription(item.getDescription());
        }

        return originalItem;
    }

    private void validateCreation(Item item) {
        if (item.getOwner() == null) {
            throw new InvalidParameterException("Owner field is required");
        }
    }

    private void validatePatch(Item original, Item patch) {
        if (patch.getOwner() == null) {
            throw new InvalidParameterException("Owner field is required");
        }
        if (!patch.getOwner().getId().equals(original.getOwner().getId())) {
            throw new InvalidParameterException("The owner of the item does not match");
        }
    }
}
