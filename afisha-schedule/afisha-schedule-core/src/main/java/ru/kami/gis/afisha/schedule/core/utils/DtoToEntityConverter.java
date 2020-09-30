package ru.kami.gis.afisha.schedule.core.utils;

import ru.kami.gis.afisha.schedule.api.dto.*;
import ru.kami.gis.afisha.schedule.core.domain.*;

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

    public static PlaceInfoDto convert(PlaceEntity placeEntity) {
        return new PlaceInfoDto(
                placeEntity.getId(),
                placeEntity.getPlace(),
                placeEntity.getHallId(),
                placeEntity.getRow(),
                true
        );
    }

    public static TicketDto convert(TicketEntity ticketEntity) {
        return new TicketDto(
                ticketEntity.getId(),
                ticketEntity.getEventId(),
                ticketEntity.getPlaceId(),
                ticketEntity.isActs()
        );
    }
}
