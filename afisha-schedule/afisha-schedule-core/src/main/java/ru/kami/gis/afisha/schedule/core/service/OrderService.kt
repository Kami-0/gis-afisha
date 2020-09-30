package ru.kami.gis.afisha.schedule.core.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.transaction.annotation.Transactional
import ru.kami.gis.afisha.schedule.api.common.exceptions.EntityNotFoundException
import ru.kami.gis.afisha.schedule.api.common.exceptions.InvalidTicketRequestException
import ru.kami.gis.afisha.schedule.api.common.types.EntityType
import ru.kami.gis.afisha.schedule.core.domain.PlaceEntity
import ru.kami.gis.afisha.schedule.core.domain.TicketEntity
import ru.kami.gis.afisha.schedule.core.repository.jdbc.api.*

/**
 * @author Daniil.Makarov
 */
class OrderService {

    @Autowired
    private val cinemaDao: CinemaDao? = null

    @Autowired
    private val cinemaHallDao: CinemaHallDao? = null

    @Autowired
    private val eventDao: EventDao? = null

    @Autowired
    private val placeDao: PlaceDao? = null

    @Autowired
    private val ticketDao: TicketDao? = null

    @Transactional
    fun makeAnOrder(eventId: Long, placesId: List<Long>): List<TicketEntity>? {
        val hallId: Long = eventDao!!
            .findEventById(eventId)
            .get()
            .hallId ?: throw EntityNotFoundException(EntityType.EVENT, eventId)

        val allHallPlaces: List<PlaceEntity> = placeDao!!
            .findAllPlacesByIdHall(hallId)
            .get()

        val occupiedPlaces = ticketDao
            ?.findAllTicketsByIdEvent(eventId)
            .orEmpty()
            .filter { it.isActs }
            .mapNotNull { it.placeId }

        //Проверяем свобны ли места которые хотят забронировать
        placesId.forEach { if (it in occupiedPlaces) throw InvalidTicketRequestException(it) }

        placesId.map { ticketDao?.insert(TicketEntity(null, eventId, it, true)) }

        return ticketDao?.findAllTicketsByIdEvent(eventId)
    }
}