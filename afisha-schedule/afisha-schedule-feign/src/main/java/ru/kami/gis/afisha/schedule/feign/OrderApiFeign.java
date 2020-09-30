package ru.kami.gis.afisha.schedule.feign;

import feign.Headers;
import feign.RequestLine;
import ru.kami.gis.afisha.schedule.api.OrderApi;
import ru.kami.gis.afisha.schedule.api.dto.PlacesOrderRequestDto;
import ru.kami.gis.afisha.schedule.api.dto.TicketDto;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Daniil.Makarov
 */
public interface OrderApiFeign extends OrderApi {
    @RequestLine("POST /order/places")
    @Headers("Content-Type: application/json")
    List<TicketDto> makeAnOrder(@Valid PlacesOrderRequestDto request);
}
