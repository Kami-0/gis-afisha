package ru.kami.gis.afisha.schedule.core.repository.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.kami.gis.afisha.schedule.core.domain.PlaceEntity;
import ru.kami.gis.afisha.schedule.core.repository.jdbc.api.PlaceDao;

import java.util.List;

/**
 * @author Daniil.Makarov
 */
@Repository
public class PlaceDaoImpl implements PlaceDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<PlaceEntity> findAllPlacesByIdHall(Long id) {
        return jdbcTemplate.query(
                "select * from public.places where hall_id = " + id,
                new BeanPropertyRowMapper<>(PlaceEntity.class)
        );
    }
}
