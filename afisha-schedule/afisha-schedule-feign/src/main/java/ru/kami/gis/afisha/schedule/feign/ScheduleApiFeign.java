package ru.kami.gis.afisha.schedule.feign;

import feign.Param;
import feign.RequestLine;
import ru.kami.gis.afisha.schedule.api.ScheduleApi;
import ru.kami.gis.afisha.schedule.api.dto.CinemaDto;
import ru.kami.gis.afisha.schedule.api.dto.CinemaHallDto;
import ru.kami.gis.afisha.schedule.api.dto.EventDto;
import ru.kami.gis.afisha.schedule.api.dto.PlaceInfoDto;

import javax.validation.constraints.Min;
import java.util.List;

import static ru.kami.gis.afisha.schedule.api.constant.ApiConstants.ID_MIN;
import static ru.kami.gis.afisha.schedule.api.constant.ApiConstants.MESSAGE_TO_NOT_VALID_ID;

/**
 * @author Daniil.Makarov
 */
public interface ScheduleApiFeign extends ScheduleApi {

    @RequestLine("GET /schedule/event/{id}")
    EventDto getEventById(@Min(value = ID_MIN, message = MESSAGE_TO_NOT_VALID_ID) @Param("id") long id);

    @RequestLine("GET /schedule/event/{id}/places")
    List<PlaceInfoDto> getAllPlacesByIdEvent(@Min(value = ID_MIN, message = MESSAGE_TO_NOT_VALID_ID) @Param("id") long id);

    @RequestLine("GET /schedule/cinemas")
    List<CinemaDto> getAllCinemas();

    @RequestLine("GET /schedule/cinema/{id}/halls")
    List<CinemaHallDto> getAllCinemaHallsById(@Min(value = ID_MIN, message = MESSAGE_TO_NOT_VALID_ID) @Param("id") long id);
}
