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
}
