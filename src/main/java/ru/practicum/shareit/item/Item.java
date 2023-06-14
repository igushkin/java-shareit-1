package ru.practicum.shareit.item;

import lombok.*;
import ru.practicum.shareit.request.ItemRequest;
import ru.practicum.shareit.user.User;

import javax.validation.constraints.NotBlank;

/**
 * TODO Sprint add-controllers.
 */
@Data
public class Item {
    private Integer id;
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @javax.validation.constraints.NotNull
    private Boolean available;
    private User owner;
    private ItemRequest request;
}
