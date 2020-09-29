package ru.kami.gis.afisha.schedule.core;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.kami.gis.afisha.schedule.api.dto.CinemaDto;
import ru.kami.gis.afisha.schedule.api.dto.CinemaHallDto;
import ru.kami.gis.afisha.schedule.api.dto.EventDto;
import ru.kami.gis.afisha.schedule.api.dto.PlaceInfoDto;
import ru.kami.gis.afisha.schedule.feign.ScheduleApiFeign;

import java.util.List;

/**
 * @author Daniil.Makarov
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class ScheduleApiFeignTest {

    @Autowired
    private ScheduleApiFeign scheduleClient;
    private Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    /**
     * Получение к события с id = 1
     */
    @Test
    void getEventById() {
        EventDto event = scheduleClient.getEventById(1);
        Assertions.assertNotNull(event);
        log("GET /schedule/event/1", event);
    }

    /**
     * Получение свободных/забронированных мест события с id = 1
     */
    @Test
    void getAllPlacesByIdEvent() {
        List<PlaceInfoDto> allPlacesByIdEvent = scheduleClient.getAllPlacesByIdEvent(1);
        Assertions.assertNotNull(allPlacesByIdEvent);
        log("GET /schedule/event/1/places", allPlacesByIdEvent);
    }

    /**
     * Получить список всех кинотеатров
     */
    @Test
    void getAllCinemas() {
        List<CinemaDto> allCinemas = scheduleClient.getAllCinemas();
        Assertions.assertNotNull(allCinemas);
        log("GET /schedule/cinemas", allCinemas);
    }

    /**
     * Получить список всех залов кинотеатра по id = 1
     */
    @Test
    void getAllCinemaHallsById() {
        List<CinemaHallDto> allCinemaHallsById = scheduleClient.getAllCinemaHallsById(1);
        Assertions.assertNotNull(allCinemaHallsById);
        log("GET /schedule/cinema/{id}/halls", allCinemaHallsById);
    }

    private void log(String nameTest, Object actual) {
        String json = gson.toJson(actual);
        log.info(System.lineSeparator() +
                "Test:{}" + System.lineSeparator() +
                "Actual:{}" + System.lineSeparator(), nameTest, json);
    }

}