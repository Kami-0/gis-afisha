package ru.kami.gis.afisha.schedule.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kami.gis.afisha.schedule.core.domain.TicketEntity;
import ru.kami.gis.afisha.schedule.core.repository.jdbc.api.EventDao;
import ru.kami.gis.afisha.schedule.core.repository.jdbc.api.PlaceDao;
import ru.kami.gis.afisha.schedule.core.repository.jdbc.api.TicketDao;

import java.util.List;

/**
 * @author Daniil.Makarov
 */
@Service
public class OrderService {
    @Autowired
    private EventDao eventDao;
    @Autowired
    private PlaceDao placeDao;
    @Autowired
    private TicketDao ticketDao;

    public List<TicketEntity> makeAnOrder(Long eventId, List<Long> placesId) {
        return new OrderServiceBiz(eventDao, placeDao, ticketDao).makeAnOrder(eventId, placesId);
    }

    public List<TicketEntity> removeAnOrder(Long eventId, List<Long> placesId) {
        return new OrderServiceBiz(eventDao, placeDao, ticketDao).removeAnOrder(eventId, placesId);
    }
}

