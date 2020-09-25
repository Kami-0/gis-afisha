package ru.kami.gis.afisha.schedule.core.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.kami.gis.afisha.schedule.core.domain.CinemaEntity;

import java.util.List;

@Repository
public class CinemaJdbcDaoImpl implements CinemaJdbcDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<CinemaEntity> findAll() {
        return jdbcTemplate.query("select * from public.cinemas",
                new BeanPropertyRowMapper<>(CinemaEntity.class)
        );
    }
}
