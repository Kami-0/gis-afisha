package ru.kami.gis.afisha.schedule.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kami.gis.afisha.schedule.api.dto.CinemaDto;
import ru.kami.gis.afisha.schedule.api.dto.CinemaHallDto;
import ru.kami.gis.afisha.schedule.api.dto.EventDto;
import ru.kami.gis.afisha.schedule.api.dto.PlaceInfoDto;
import ru.kami.gis.afisha.schedule.core.domain.PlaceEntity;
import ru.kami.gis.afisha.schedule.core.domain.TicketEntity;
import ru.kami.gis.afisha.schedule.core.repository.jdbc.api.*;
import ru.kami.gis.afisha.schedule.core.utils.DtoToEntityConverter;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Daniil.Makarov
 */
@Service
public class ScheduleService {

    @Autowired
    private CinemaDao cinemaDao;
    @Autowired
    private CinemaHallDao cinemaHallDao;
    @Autowired
    private EventDao eventDao;
    @Autowired
    private PlaceDao placeDao;
    @Autowired
    private TicketDao ticketDao;

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
        //todo реализовать
        return null;
    }

    @Transactional
    public List<PlaceInfoDto> getAllPlacesByIdEvent(long eventId) {
        long hallId = eventDao.findEventById(eventId).getHallId();
        List<PlaceEntity> allHallPlaces = placeDao.findAllPlacesByIdHall(hallId);
        List<TicketEntity> tickets = ticketDao.findAllTicketsByIdEvent(eventId);

        List<Long> occupiedPlacesId = tickets
                .stream()
                .filter(TicketEntity::getIsActs)
                .map(TicketEntity::getPlaceId)
                .collect(Collectors.toList());

        return allHallPlaces
                .stream()
                .map(DtoToEntityConverter::convert)
                .peek(it -> {
                    if (containIdInList(it.getId(), occupiedPlacesId)) {
                        it.setIsFree(false);
                    }
                })
                .collect(Collectors.toList());
    }

    private boolean containIdInList(Long id, List<Long> listId) {
        return listId.stream().anyMatch(it -> it.equals(id));
    }
}
