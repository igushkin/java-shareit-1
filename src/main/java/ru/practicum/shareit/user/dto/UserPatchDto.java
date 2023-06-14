package ru.practicum.shareit.user.dto;

import lombok.Data;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class UserPatchDto {
    private String name;
    @Email
    private String email;
}
