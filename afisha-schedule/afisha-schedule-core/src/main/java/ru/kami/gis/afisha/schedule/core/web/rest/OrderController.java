package ru.kami.gis.afisha.schedule.core.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kami.gis.afisha.schedule.api.OrderApi;
import ru.kami.gis.afisha.schedule.api.dto.PlacesOrderRequestDto;
import ru.kami.gis.afisha.schedule.api.dto.TicketDto;
import ru.kami.gis.afisha.schedule.core.service.OrderService;
import ru.kami.gis.afisha.schedule.core.utils.DtoToEntityConverter;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Daniil.Makarov
 */
@RestController
@Validated
@RequestMapping(value = "/order")
public class OrderController implements OrderApi {
    @Autowired
    private OrderService orderService;

    /**
     * Забронировать места
     *
     * @return в случае успеха возращает экземляры забронированных мест
     */
    @Override
    @PostMapping(value = "/places")
    public List<TicketDto> makeAnOrder(@RequestBody PlacesOrderRequestDto request) {
        return orderService
                .makeAnOrder(request.getEventId(), request.getPlacesId())
                .stream()
                .map(DtoToEntityConverter::convert)
                .collect(Collectors.toList());
    }

    /**
     * Отменить бронь мест
     *
     * @return в случае успеха возращает экземляры забронированных мест
     */
    @Override
    @PostMapping(value = "/remove/places")
    public List<TicketDto> removeAnOrder(@RequestBody PlacesOrderRequestDto request) {
        return orderService
                .removeAnOrder(request.getEventId(), request.getPlacesId())
                .stream()
                .map(DtoToEntityConverter::convert)
                .collect(Collectors.toList());
    }
}
