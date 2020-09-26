package ru.kami.gis.afisha.schedule.core.repository.jdbc.api

import ru.kami.gis.afisha.schedule.api.repository.JdbcDaoInterface
import ru.kami.gis.afisha.schedule.core.domain.EventEntity

/**
 * @author Daniil.Makarov
 */
interface EventDao : JdbcDaoInterface {
    fun findEventById(id: Long): EventEntity?
}