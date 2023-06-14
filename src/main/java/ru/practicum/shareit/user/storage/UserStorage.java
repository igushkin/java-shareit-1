package ru.practicum.shareit.user.storage;

import ru.practicum.shareit.user.User;
import ru.practicum.shareit.user.dto.UserPatchDto;

import java.util.List;

public interface UserStorage {
    List<User> getUsers();

    User getUserById(Integer id);

    User createUser(User user);

    User patchUser(UserPatchDto userPatchDto, Integer id);

    void deleteUser(Integer id);
}
