package ru.kami.gis.afisha.schedule.core.repository.jdbc

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository
import ru.kami.gis.afisha.schedule.core.domain.PlaceEntity
import ru.kami.gis.afisha.schedule.core.repository.jdbc.api.PlaceDao

@Repository
class PlaceDaoImpl(
    @Autowired
    var jdbcTemplate: JdbcTemplate
) : PlaceDao {

    override fun findAllPlacesByIdHall(id: Long): List<PlaceEntity?> {
        return jdbcTemplate.query(
            "select * from public.places where hall_id = $id",
            BeanPropertyRowMapper(PlaceEntity::class.java)
        )
    }

}