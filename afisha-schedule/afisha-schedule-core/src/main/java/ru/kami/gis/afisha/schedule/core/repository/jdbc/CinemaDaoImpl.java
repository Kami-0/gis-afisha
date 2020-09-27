package ru.kami.gis.afisha.schedule.core.repository.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.kami.gis.afisha.schedule.core.domain.CinemaEntity;
import ru.kami.gis.afisha.schedule.core.repository.jdbc.api.CinemaDao;

import java.util.List;

/**
 * @author Daniil.Makarov
 */
@Repository
public class CinemaDaoImpl implements CinemaDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<CinemaEntity> findAll() {
        return jdbcTemplate.query("select * from public.cinemas",
                new BeanPropertyRowMapper<>(CinemaEntity.class));
    }
}
