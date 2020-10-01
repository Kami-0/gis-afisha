package ru.kami.gis.afisha.schedule.core.repository.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.kami.gis.afisha.schedule.core.domain.TicketEntity;
import ru.kami.gis.afisha.schedule.core.repository.jdbc.api.TicketDao;

import java.util.List;

/**
 * @author Daniil.Makarov
 */
@Repository
public class TicketDaoImpl implements TicketDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<TicketEntity> findAllTicketsByIdEvent(Long eventId) {
        return jdbcTemplate.query(
                "select * from public.tickets where event_id = " + eventId,
                new BeanPropertyRowMapper<>(TicketEntity.class)
        );
    }

    @Override
    public int insert(TicketEntity ticketEntity) {
        return jdbcTemplate.update("insert into public.tickets " +
                        "(event_id, place_id, is_acts) " +
                        "values (?,?,?)",
                ticketEntity.getEventId(),
                ticketEntity.getPlaceId(),
                ticketEntity.isActs());
    }

    @Override
    public int cancelReservation(TicketEntity ticketEntity) {
        return jdbcTemplate.update("update public.tickets set " +
                        "is_acts = ? " +
                        "where event_id = ? and place_id = ?",
                ticketEntity.isActs(),
                ticketEntity.getEventId(),
                ticketEntity.getPlaceId()
        );
    }
}
