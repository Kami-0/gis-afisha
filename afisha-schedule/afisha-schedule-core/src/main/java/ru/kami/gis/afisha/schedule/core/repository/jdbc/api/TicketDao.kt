package ru.kami.gis.afisha.schedule.core.repository.jdbc.api

import ru.kami.gis.afisha.schedule.api.repository.JdbcDaoInterface
import ru.kami.gis.afisha.schedule.core.domain.TicketEntity

/**
 * @author Daniil.Makarov
 */
interface TicketDao : JdbcDaoInterface {
    fun findAllTicketsByIdHallAndEvent(hallId: Long, eventId: Long): List<TicketEntity?>
}