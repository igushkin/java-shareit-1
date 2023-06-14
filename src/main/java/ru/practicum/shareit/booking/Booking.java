package ru.practicum.shareit.booking;

import java.sql.Timestamp;

import lombok.Data;
import ru.practicum.shareit.item.Item;
import ru.practicum.shareit.user.User;

/**
 * TODO Sprint add-bookings.
 */
@Data
public class Booking {
    private Integer id;
    private Timestamp start;
    private Timestamp end;
    private Item item;
    private User booker;
    private BookingStatus status;


    /*
    id — уникальный идентификатор бронирования;
    start — дата и время начала бронирования;
    end — дата и время конца бронирования;
    item — вещь, которую пользователь бронирует;
    booker — пользователь, который осуществляет бронирование;
    status — статус бронирования. Может принимать одно из следующих
    значений: WAITING — новое бронирование, ожидает одобрения, APPROVED —
    Дополнительные советы ментора 2
    бронирование подтверждено владельцем, REJECTED — бронирование
    отклонено владельцем, CANCELED — бронирование отменено создателем.
     */
}
