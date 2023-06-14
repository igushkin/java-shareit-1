package ru.practicum.shareit.user.storage;

public class UserIdGenerator {
    private static Integer id = 1;

    public static Integer getId() {
        return id++;
    }
}

