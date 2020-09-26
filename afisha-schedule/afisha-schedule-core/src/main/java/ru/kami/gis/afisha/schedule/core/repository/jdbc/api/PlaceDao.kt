package ru.kami.gis.afisha.schedule.core.repository.jdbc.api

import ru.kami.gis.afisha.schedule.core.domain.PlaceEntity

/**
 * @author Daniil.Makarov
 */
interface PlaceDao {
    fun findAllPlacesByIdHall(id: Long): List<PlaceEntity?>
}