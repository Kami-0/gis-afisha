package ru.kami.gis.afisha.schedule.core.repository.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.kami.gis.afisha.schedule.core.domain.CinemaHallEntity;
import ru.kami.gis.afisha.schedule.core.repository.jdbc.api.CinemaHallDao;

import java.util.List;
import java.util.Optional;

/**
 * @author Daniil.Makarov
 */
@Repository
public class CinemaHallDaoImpl implements CinemaHallDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Optional<List<CinemaHallEntity>> findAllByIdCinema(Long id) {
        List<CinemaHallEntity> query = jdbcTemplate.query(
                "select * from public.halls where cinema_id = " + id,
                new BeanPropertyRowMapper<>(CinemaHallEntity.class)
        );
        return query.isEmpty() ? Optional.empty() : Optional.of(query);
    }
}

