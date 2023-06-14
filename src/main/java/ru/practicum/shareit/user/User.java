package ru.practicum.shareit.user;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * TODO Sprint add-controllers.
 */
@Data
public class User {
    private Integer id;
    private String name;
    @NotBlank
    @Email
    private String email;
}
