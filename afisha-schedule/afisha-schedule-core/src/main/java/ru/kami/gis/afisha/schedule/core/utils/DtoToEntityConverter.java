package ru.kami.gis.afisha.schedule.core.utils;

import ru.kami.gis.afisha.schedule.api.dto.CinemaDto;
import ru.kami.gis.afisha.schedule.core.domain.CinemaEntity;

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

}
