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

    @Override
    @GetMapping(value = "/cinemas")
    public List<CinemaDto> getAllCinemas() {
        return scheduleService.getAllCinemas();
    }

    @Override
    @GetMapping(value = "/cinema/{id}/halls")
    public List<CinemaHallDto> getAllCinemaHallsById(@PathVariable long id) {
        return scheduleService.getAllCinemaHallsById(id);
    }

    @Override
    @GetMapping(value = "/event/{id}")
    public EventDto getEventById(@PathVariable long id) {
        return scheduleService.getEventById(id);
    }

    @Override
    @GetMapping(value = "/event/{id}/cinemas")
    public List<CinemaDto> getAllEventCinemasById(@PathVariable long id) {
        return scheduleService.getAllEventCinemasById(id);
    }
}
