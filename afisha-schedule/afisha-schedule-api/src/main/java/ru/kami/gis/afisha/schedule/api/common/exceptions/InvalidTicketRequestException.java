package ru.kami.gis.afisha.schedule.api.common.exceptions;

import lombok.Getter;

/**
 * @author Daniil.Makarov
 */
@Getter
public class InvalidTicketRequestException extends RuntimeException {
    private final String message;

    public InvalidTicketRequestException(long placeId) {
        this.message = "Место с id: " + placeId + " уже забронированно";
    }
}
