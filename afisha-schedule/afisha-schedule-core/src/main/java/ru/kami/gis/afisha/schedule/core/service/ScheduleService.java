package ru.kami.gis.afisha.schedule.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kami.gis.afisha.schedule.api.dto.CinemaDto;
import ru.kami.gis.afisha.schedule.api.dto.CinemaHallDto;
import ru.kami.gis.afisha.schedule.api.dto.EventDto;
import ru.kami.gis.afisha.schedule.api.dto.PlaceDto;
import ru.kami.gis.afisha.schedule.core.domain.EventEntity;
import ru.kami.gis.afisha.schedule.core.domain.PlaceEntity;
import ru.kami.gis.afisha.schedule.core.repository.jdbc.CinemaDaoImpl;
import ru.kami.gis.afisha.schedule.core.repository.jdbc.CinemaHallDaoImpl;
import ru.kami.gis.afisha.schedule.core.repository.jdbc.EventDaoImpl;
import ru.kami.gis.afisha.schedule.core.repository.jdbc.PlaceDaoImpl;
import ru.kami.gis.afisha.schedule.core.utils.DtoToEntityConverter;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Daniil.Makarov
 */
@Service
public class ScheduleService {

    @Autowired
    private CinemaDaoImpl cinemaDao;
    @Autowired
    private CinemaHallDaoImpl cinemaHallDao;
    @Autowired
    private EventDaoImpl eventDao;
    @Autowired
    private PlaceDaoImpl placeDao;

    @Transactional
    public List<CinemaDto> getAllCinemas() {
        return cinemaDao
                .findAll()
                .stream()
                .map(DtoToEntityConverter::convert)
                .collect(Collectors.toList());
    }

    @Transactional
    public List<CinemaHallDto> getAllCinemaHallsById(long id) {
        return cinemaHallDao
                .findAllByIdCinema(id)
                .stream()
                .map(DtoToEntityConverter::convert)
                .collect(Collectors.toList());
    }

    @Transactional
    public EventDto getEventById(long id) {
        return DtoToEntityConverter.convert(eventDao.findEventById(id));
    }

    @Transactional
    public List<CinemaDto> getAllEventCinemasById(long id) {
        return null;
    }

    @Transactional
    public List<PlaceDto> getAllPlacesByIdEvent(long id) {
        EventEntity eventById = eventDao.findEventById(id);
        List<PlaceEntity> allPlacesByIdHall = placeDao.findAllPlacesByIdHall(eventById.getHallId());

        return null;
    }
}
