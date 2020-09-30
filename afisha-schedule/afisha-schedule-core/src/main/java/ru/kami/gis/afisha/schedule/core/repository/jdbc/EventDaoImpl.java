package ru.kami.gis.afisha.schedule.core.repository.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.kami.gis.afisha.schedule.core.domain.EventEntity;
import ru.kami.gis.afisha.schedule.core.repository.jdbc.api.EventDao;

import java.util.Optional;

/**
 * @author Daniil.Makarov
 */
@Repository
public class EventDaoImpl implements EventDao {
    private static final int FIRST_INDEX = 0;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Optional<EventEntity> findEventById(Long id) {
        return Optional.ofNullable(jdbcTemplate.query(
                "select * from public.events where id = " + id,
                new BeanPropertyRowMapper<>(EventEntity.class)
        ).get(FIRST_INDEX));
    }
}
