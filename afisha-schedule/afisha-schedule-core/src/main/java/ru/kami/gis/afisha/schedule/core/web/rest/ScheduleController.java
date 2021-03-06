package ru.kami.gis.afisha.schedule.core.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kami.gis.afisha.schedule.api.ScheduleApi;
import ru.kami.gis.afisha.schedule.api.dto.CinemaDto;
import ru.kami.gis.afisha.schedule.api.dto.CinemaHallDto;
import ru.kami.gis.afisha.schedule.api.dto.EventDto;
import ru.kami.gis.afisha.schedule.api.dto.PlaceInfoDto;
import ru.kami.gis.afisha.schedule.core.service.ScheduleService;

import java.util.List;

/**
 * @author Daniil.Makarov
 */
@RestController
@Validated
@RequestMapping(value = "/schedule")
public class ScheduleController implements ScheduleApi {

    @Autowired
    private ScheduleService scheduleService;

    /**
     * Получить список всех кинотеатров
     *
     * @return список кинотеатров
     */
    @Override
    @GetMapping(value = "/cinemas")
    public List<CinemaDto> getAllCinemas() {
        return scheduleService.getAllCinemas();
    }

    /**
     * Получить все залы кинотеатра по его индетификатору
     *
     * @param id кинотетра
     * @return список всех залов кинотеатра
     */
    @Override
    @GetMapping(value = "/cinema/{id}/halls")
    public List<CinemaHallDto> getAllCinemaHallsById(@PathVariable long id) {
        return scheduleService.getAllCinemaHallsById(id);
    }

    /**
     * Получить событие по его индетификатору
     *
     * @param id события
     * @return событие
     */
    @Override
    @GetMapping(value = "/event/{id}")
    public EventDto getEventById(@PathVariable long id) {
        return scheduleService.getEventById(id);
    }

    /**
     * Получить список мест в зале со статусами свободно/забронировано по id события
     *
     * @param id события
     * @return список мест
     */
    @Override
    @GetMapping(value = "/event/{id}/places")
    public List<PlaceInfoDto> getAllPlacesByIdEvent(@PathVariable long id) {
        return scheduleService.getAllPlacesByIdEvent(id);
    }
}
