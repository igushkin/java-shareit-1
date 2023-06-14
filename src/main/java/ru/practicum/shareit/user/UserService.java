package ru.practicum.shareit.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.practicum.shareit.user.dto.UserPatchDto;
import ru.practicum.shareit.user.storage.UserStorage;

import java.util.List;

@Service
public class UserService {

    private final UserStorage userStorage;

    @Autowired
    public UserService(UserStorage userStorage) {
        this.userStorage = userStorage;
    }

    public List<User> getUsers() {
        return userStorage.getUsers();
    }

    public User getUserById(Integer id) {
        return userStorage.getUserById(id);
    }

    public User createUser(User user) {
        return userStorage.createUser(user);
    }

    public User patchUser(UserPatchDto userPatchDto, Integer id) {
        return userStorage.patchUser(userPatchDto, id);
    }

    public void deleteUser(Integer id) {
        userStorage.deleteUser(id);
    }
}
