package ru.kami.gis.afisha.schedule.core.repository.jdbc.api;

import ru.kami.gis.afisha.schedule.api.repository.JdbcDaoInterface;
import ru.kami.gis.afisha.schedule.core.domain.EventEntity;

import java.util.Optional;

/**
 * @author Daniil.Makarov
 */
public interface EventDao extends JdbcDaoInterface {
    Optional<EventEntity> findEventById(Long id);
}
