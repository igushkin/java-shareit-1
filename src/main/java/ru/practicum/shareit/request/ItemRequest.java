package ru.practicum.shareit.request;

import lombok.Data;
import ru.practicum.shareit.user.User;

import java.sql.Timestamp;

/**
 * TODO Sprint add-item-requests.
 */
@Data
public class ItemRequest {
    private Integer id;
    private String description;
    private User requestor;
    private Timestamp created;

    /*
    id — уникальный идентификатор запроса;
    description — текст запроса, содержащий описание требуемой вещи;
    requestor — пользователь, создавший запрос;
    created — дата и время создания запроса.

     */
}
