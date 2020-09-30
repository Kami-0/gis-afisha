package ru.kami.gis.afisha.schedule.core.repository.jdbc.api;

import ru.kami.gis.afisha.schedule.api.repository.JdbcDaoInterface;
import ru.kami.gis.afisha.schedule.core.domain.CinemaHallEntity;

import java.util.List;
import java.util.Optional;

/**
 * @author Daniil.Makarov
 */
public interface CinemaHallDao extends JdbcDaoInterface {
    Optional<List<CinemaHallEntity>> findAllByIdCinema(Long id);
}
