package ru.kami.gis.afisha.schedule.core.repository.jdbc.api;

import ru.kami.gis.afisha.schedule.api.repository.JdbcDaoInterface;
import ru.kami.gis.afisha.schedule.core.domain.EventEntity;

/**
 * @author Daniil.Makarov
 */
public interface EventDao extends JdbcDaoInterface {
    EventEntity findEventById(Long id);
}
