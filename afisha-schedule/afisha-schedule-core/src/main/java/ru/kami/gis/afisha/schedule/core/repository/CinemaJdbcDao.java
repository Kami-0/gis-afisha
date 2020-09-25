package ru.kami.gis.afisha.schedule.core.repository;

import ru.kami.gis.afisha.schedule.core.domain.CinemaEntity;

import java.util.List;

/**
 * @author Daniil.Makarov
 */
public interface CinemaJdbcDao {
    List<CinemaEntity> findAll();
}
