package ru.kami.gis.afisha.schedule.core.repository.jdbc

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository
import ru.kami.gis.afisha.schedule.core.domain.CinemaEntity
import ru.kami.gis.afisha.schedule.core.repository.jdbc.api.CinemaDao

@Repository
class CinemaDaoImpl(
    @Autowired
    var jdbcTemplate: JdbcTemplate
) : CinemaDao {

    override fun findAll(): List<CinemaEntity?> {
        return jdbcTemplate.query(
            "select * from public.cinemas",
            BeanPropertyRowMapper(CinemaEntity::class.java)
        )
    }

}