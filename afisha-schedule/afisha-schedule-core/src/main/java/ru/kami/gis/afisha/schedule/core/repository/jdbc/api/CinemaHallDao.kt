package ru.kami.gis.afisha.schedule.core.repository.jdbc.api

import ru.kami.gis.afisha.schedule.api.repository.JdbcDaoInterface
import ru.kami.gis.afisha.schedule.core.domain.CinemaHallEntity

/**
 * @author Daniil.Makarov
 */
interface CinemaHallDao : JdbcDaoInterface {
    fun findAllByIdCinema(id: Long): List<CinemaHallEntity?>
}