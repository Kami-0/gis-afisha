package ru.kami.gis.afisha.schedule.api;

import ru.kami.gis.afisha.schedule.api.dto.PlacesOrderRequestDto;
import ru.kami.gis.afisha.schedule.api.dto.TicketDto;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Daniil.Makarov
 */
public interface OrderApi {
    /**
     * Забронировать места
     *
     * @return в случае успеха возращает экземляры забронированных мест
     */
    List<TicketDto> makeAnOrder(@Valid PlacesOrderRequestDto request);
}
