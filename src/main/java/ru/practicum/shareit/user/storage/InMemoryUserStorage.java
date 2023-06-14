package ru.practicum.shareit.user.storage;

import org.springframework.stereotype.Component;
import ru.practicum.shareit.user.User;
import ru.practicum.shareit.user.dto.UserPatchDto;

import java.util.*;

@Component
public class InMemoryUserStorage implements UserStorage {
    private final Map<Integer, User> userStorage;
    private final Set<String> emailStorage;

    public InMemoryUserStorage() {
        this.userStorage = new HashMap<>();
        this.emailStorage = new HashSet<>();
    }

    @Override
    public List<User> getUsers() {
        return new ArrayList<>(userStorage.values());
    }

    @Override
    public User getUserById(Integer id) {
        return userStorage.get(id);
    }

    @Override
    public void deleteUser(Integer id) {
        validateRemoval(id);

        emailStorage.remove(userStorage.get(id).getEmail());
        userStorage.remove(id);
    }

    public User createUser(User user) {
        validateCreation(user);

        user.setId(UserIdGenerator.getId());
        userStorage.put(user.getId(), user);
        emailStorage.add(user.getEmail());

        return user;
    }

    @Override
    public User patchUser(UserPatchDto userPatchDto, Integer id) {
        validatePatch(userPatchDto, id);

        var originalUser = userStorage.get(id);

        if (userPatchDto.getName() != null) {
            originalUser.setName(userPatchDto.getName());
        }
        if (userPatchDto.getEmail() != null) {
            emailStorage.remove(originalUser.getEmail());
            emailStorage.add(userPatchDto.getEmail());

            originalUser.setEmail(userPatchDto.getEmail());
        }

        return originalUser;
    }

    private void validateCreation(User user) {
        if (emailStorage.contains(user.getEmail())) {
            throw new RuntimeException();
        }
    }

    private void validateRemoval(Integer id) {
        if (!userStorage.containsKey(id)) {
            throw new RuntimeException();
        }
    }

    private void validatePatch(UserPatchDto userPatchDto, Integer id) {
        if (!userStorage.containsKey(id)) {
            throw new RuntimeException();
        }
        var originalUser = userStorage.get(id);
        if (emailStorage.contains(userPatchDto.getEmail()) && !userPatchDto.getEmail().equals(originalUser.getEmail())) {
            throw new RuntimeException();
        }
    }
}
