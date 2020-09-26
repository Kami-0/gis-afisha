package ru.kami.gis.afisha.schedule.core.repository.jdbc.api

import ru.kami.gis.afisha.schedule.api.repository.JdbcDaoInterface
import ru.kami.gis.afisha.schedule.core.domain.CinemaEntity

/**
 * @author Daniil.Makarov
 */
interface CinemaDao : JdbcDaoInterface {
    fun findAll(): List<CinemaEntity?>
}