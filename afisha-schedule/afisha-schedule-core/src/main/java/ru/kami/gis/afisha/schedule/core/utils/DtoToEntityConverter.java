package ru.kami.gis.afisha.schedule.core.utils;

import ru.kami.gis.afisha.schedule.api.dto.CinemaDto;
import ru.kami.gis.afisha.schedule.api.dto.CinemaHallDto;
import ru.kami.gis.afisha.schedule.api.dto.EventDto;
import ru.kami.gis.afisha.schedule.core.domain.CinemaEntity;
import ru.kami.gis.afisha.schedule.core.domain.CinemaHallEntity;
import ru.kami.gis.afisha.schedule.core.domain.EventEntity;

/**
 * @author Daniil.Makarov
 */
public final class DtoToEntityConverter {

    public static CinemaDto convert(CinemaEntity cinemaEntity) {
        return new CinemaDto(
                cinemaEntity.getId(),
                cinemaEntity.getName()
        );
    }

    public static CinemaHallDto convert(CinemaHallEntity cinemaHallEntity) {
        return new CinemaHallDto(
                cinemaHallEntity.getId(),
                cinemaHallEntity.getNumber(),
                cinemaHallEntity.getPlacesNumber(),
                cinemaHallEntity.getCinemaId()
        );
    }

    public static EventDto convert(EventEntity eventEntity) {
        return new EventDto(
                eventEntity.getId(),
                eventEntity.getHallId(),
                eventEntity.getName(),
                eventEntity.getAgeRestriction(),
                eventEntity.getDuration()
        );
    }
}
