package ru.kami.gis.afisha.schedule.core.repository.jdbc

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository
import ru.kami.gis.afisha.schedule.core.domain.CinemaHallEntity
import ru.kami.gis.afisha.schedule.core.repository.jdbc.api.CinemaHallDao

/**
 * @author Daniil.Makarov
 */
@Repository
class CinemaHallDaoImpl(
    @Autowired
    var jdbcTemplate: JdbcTemplate
) : CinemaHallDao {

    override fun findAllByIdCinema(id: Long): List<CinemaHallEntity?> {
        return jdbcTemplate.query(
            "select * from public.halls where cinema_id = $id",
            BeanPropertyRowMapper(CinemaHallEntity::class.java)
        )
    }

}