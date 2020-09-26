package ru.kami.gis.afisha.schedule.core.repository.jdbc

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository
import ru.kami.gis.afisha.schedule.core.domain.TicketEntity
import ru.kami.gis.afisha.schedule.core.repository.jdbc.api.TicketDao

@Repository
class TicketDaoImpl(
    @Autowired
    var jdbcTemplate: JdbcTemplate
) : TicketDao {

    override fun findAllTicketsByIdHallAndEvent(hallId: Long, eventId: Long): List<TicketEntity?> {
        return jdbcTemplate.query(
            "select * from public.events where event_id = $eventId and place_id = $hallId",
            BeanPropertyRowMapper(TicketEntity::class.java)
        )
    }

}