package ru.kami.gis.afisha.schedule.core.repository.jdbc

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository
import ru.kami.gis.afisha.schedule.core.domain.EventEntity
import ru.kami.gis.afisha.schedule.core.repository.jdbc.api.EventDao

@Repository
class EventDaoImpl(
    @Autowired
    var jdbcTemplate: JdbcTemplate
) : EventDao {

    override fun findEventById(id: Long): EventEntity? {
        return jdbcTemplate.query(
            "select * from public.events where id = $id",
            BeanPropertyRowMapper(EventEntity::class.java)
        ).first()
    }

}