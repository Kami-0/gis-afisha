package ru.kami.gis.afisha.schedule.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kami.gis.afisha.schedule.api.dto.CinemaDto;
import ru.kami.gis.afisha.schedule.api.dto.CinemaHallDto;
import ru.kami.gis.afisha.schedule.api.dto.EventDto;
import ru.kami.gis.afisha.schedule.core.repository.jdbc.CinemaDaoImpl;
import ru.kami.gis.afisha.schedule.core.repository.jdbc.CinemaHallDaoImpl;
import ru.kami.gis.afisha.schedule.core.repository.jdbc.EventDaoImpl;
import ru.kami.gis.afisha.schedule.core.utils.DtoToEntityConverter;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Daniil.Makarov
 */
@Service
public class ScheduleService {

    @Autowired
    private CinemaDaoImpl cinemaJdbcDao;
    @Autowired
    private CinemaHallDaoImpl cinemaHallJdbcDao;
    @Autowired
    private EventDaoImpl eventDao;

    public List<CinemaDto> getAllCinemas() {
        return cinemaJdbcDao
                .findAll()
                .stream()
                .map(DtoToEntityConverter::convert)
                .collect(Collectors.toList());
    }

    public List<CinemaHallDto> getAllCinemaHallsById(long id) {
        return cinemaHallJdbcDao
                .findAllByIdCinema(id)
                .stream()
                .map(DtoToEntityConverter::convert)
                .collect(Collectors.toList());
    }

    public EventDto getEventById(long id) {
        return DtoToEntityConverter.convert(eventDao.findEventById(id));
    }

    public List<CinemaDto> getAllEventCinemasById(long id) {
        return null;
    }
}
