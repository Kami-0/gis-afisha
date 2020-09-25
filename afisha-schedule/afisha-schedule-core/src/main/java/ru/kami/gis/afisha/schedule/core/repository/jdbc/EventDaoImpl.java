package ru.kami.gis.afisha.schedule.core.repository.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.kami.gis.afisha.schedule.core.domain.EventEntity;
import ru.kami.gis.afisha.schedule.core.repository.jdbc.api.EventDao;

@Repository
public class EventDaoImpl implements EventDao {
    private static final int FIRST_VALUE_INDEX = 0;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public EventEntity findEventById(long id) {
        return jdbcTemplate.query("select * from public.events where id = " + id,
                new BeanPropertyRowMapper<>(EventEntity.class)
        ).get(FIRST_VALUE_INDEX);
    }
}
