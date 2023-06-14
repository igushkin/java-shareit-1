package ru.practicum.shareit.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.InvalidParameterException;
import java.util.List;

@RestController
@RequestMapping(path = "/items")
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("{id}")
    public Item getItemById(@PathVariable Integer id) {
        return itemService.getItemById(id);
    }

    @GetMapping
    public List<Item> getAllByUserId(@RequestHeader(value = "X-Sharer-User-Id") Integer userId) {
        return itemService.getAllByUserId(userId);
    }

    @GetMapping("/search")
    public List<Item> findItemByText(@RequestParam(name = "text") String text) {
        return itemService.findItemByText(text);
    }

    @PostMapping
    public Item createItem(@RequestHeader(value = "X-Sharer-User-Id") Integer userId, @Valid @RequestBody Item item) {
        return itemService.createItem(userId, item);
    }

    @PatchMapping("{id}")
    public Item patchItem(@RequestHeader(value = "X-Sharer-User-Id") Integer userId, @RequestBody Item item, @PathVariable Integer id) {
        return itemService.patchItem(item, id, userId);
    }

    @ExceptionHandler({InvalidParameterException.class})
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public String handleException(Exception e) {
        return e.getMessage();
    }
}
