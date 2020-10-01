package ru.kami.gis.afisha.schedule.core;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.kami.gis.afisha.schedule.api.dto.PlacesOrderRequestDto;
import ru.kami.gis.afisha.schedule.api.dto.TicketDto;
import ru.kami.gis.afisha.schedule.feign.OrderApiFeign;

import java.util.Arrays;
import java.util.List;

/**
 * @author Daniil.Makarov
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class OrderApiFeignTest {

    @Autowired
    private OrderApiFeign orderClient;
    private PlacesOrderRequestDto requestDto;
    private Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    @BeforeEach
    void setUp() {
        requestDto = PlacesOrderRequestDto.builder()
                .eventId(1L)
                .placesId(Arrays.asList(1L, 2L))
                .build();
    }

    /**
     * Бронирование билетов
     */
    @Test
    void getEventById() {
        List<TicketDto> ticketDtos = orderClient.makeAnOrder(requestDto);
        Assertions.assertNotNull(ticketDtos);
        log("POST /order/places", ticketDtos);
        orderClient.removeAnOrder(requestDto);
    }

    private void log(String nameTest, Object actual) {
        String json = gson.toJson(actual);
        log.info(System.lineSeparator() +
                "Test:{}" + System.lineSeparator() +
                "Actual:{}" + System.lineSeparator(), nameTest, json);
    }

}