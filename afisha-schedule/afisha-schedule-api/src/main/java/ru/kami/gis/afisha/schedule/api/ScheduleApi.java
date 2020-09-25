package ru.kami.gis.afisha.schedule.api;

import ru.kami.gis.afisha.schedule.api.constant.ApiConstants;
import ru.kami.gis.afisha.schedule.api.dto.CinemaDto;
import ru.kami.gis.afisha.schedule.api.dto.CinemaHallDto;
import ru.kami.gis.afisha.schedule.api.dto.EventDto;

import javax.validation.constraints.Min;
import java.util.List;

/**
 * @author Daniil.Makarov
 */
public interface ScheduleApi {
    /**
     * Получить список всех кинотеатров
     *
     * @return список кинотеатров
     */
    List<CinemaDto> getAllCinemas();

    /**
     * Получить событие по его индетификатору
     *
     * @param id события
     * @return событие
     */
    EventDto getEventById(@Min(value = ApiConstants.ID_MIN, message = ApiConstants.MESSAGE_TO_NOT_VALID_ID) long id);

    /**
     * Получить все кинотеатры где проходит событие по индетификатору
     *
     * @param id события
     * @return список кинотеатров в которых проходит событие
     */
    List<CinemaDto> getAllEventCinemasById(@Min(value = ApiConstants.ID_MIN, message = ApiConstants.MESSAGE_TO_NOT_VALID_ID) long id);

    /**
     * Получить все залы кинотеатра по его индетификатору
     *
     * @param id кинотетра
     * @return список всех залов кинотеатра
     */
    List<CinemaHallDto> getAllCinemaHallsById(@Min(value = ApiConstants.ID_MIN, message = ApiConstants.MESSAGE_TO_NOT_VALID_ID) long id);

}
