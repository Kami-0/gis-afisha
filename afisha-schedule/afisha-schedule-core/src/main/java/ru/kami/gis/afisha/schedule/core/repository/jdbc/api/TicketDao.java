package ru.kami.gis.afisha.schedule.core.repository.jdbc.api;

import ru.kami.gis.afisha.schedule.api.repository.JdbcDaoInterface;
import ru.kami.gis.afisha.schedule.core.domain.TicketEntity;

import java.util.List;

/**
 * @author Daniil.Makarov
 */
public interface TicketDao extends JdbcDaoInterface {
    List<TicketEntity> findAllTicketsByIdEvent(Long eventId);

    int insert(TicketEntity ticketEntity);
}
