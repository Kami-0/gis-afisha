package ru.kami.gis.afisha.schedule.api.common.exceptions;

import lombok.Getter;
import ru.kami.gis.afisha.schedule.api.common.types.EntityType;

/**
 * @author Daniil.Makarov
 */
@Getter
public class EntityNotFoundException extends RuntimeException {
    private final EntityType entityType;
    private final String message;

    public EntityNotFoundException(EntityType entityType, long id) {
        this.entityType = entityType;
        this.message = "Сущность с id: " + id + " не существует";
    }
}
