package ru.kami.gis.afisha.schedule.core.repository.jdbc.api;

import ru.kami.gis.afisha.schedule.api.repository.JdbcDaoInterface;
import ru.kami.gis.afisha.schedule.core.domain.PlaceEntity;

import java.util.List;
import java.util.Optional;

/**
 * @author Daniil.Makarov
 */
public interface PlaceDao extends JdbcDaoInterface {
    Optional<List<PlaceEntity>> findAllPlacesByIdHall(Long id);
}
