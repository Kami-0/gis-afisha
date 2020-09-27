package ru.kami.gis.afisha.schedule.core.repository.jdbc.api;

import ru.kami.gis.afisha.schedule.api.repository.JdbcDaoInterface;
import ru.kami.gis.afisha.schedule.core.domain.CinemaEntity;

import java.util.List;

/**
 * @author Daniil.Makarov
 */
public interface CinemaDao extends JdbcDaoInterface {
    List<CinemaEntity> findAll();
}
