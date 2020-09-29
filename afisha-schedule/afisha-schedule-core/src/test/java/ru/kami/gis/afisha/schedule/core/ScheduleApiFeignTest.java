package ru.kami.gis.afisha.schedule.core;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.kami.gis.afisha.schedule.api.dto.EventDto;
import ru.kami.gis.afisha.schedule.feign.ScheduleApiFeign;

/**
 * @author Daniil.Makarov
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class ScheduleApiFeignTest {

    @Autowired
    private ScheduleApiFeign scheduleClient;
    @Autowired
    private Gson gson;

    /**
     * Обращает к событию с id = 1
     */
    @Test
    void getEventById() {
        EventDto event = scheduleClient.getEventById(1);
        Assertions.assertNotNull(event);
        String json = gson.toJson(event);
        log("GET /schedule/event/1/places", json);
    }

    private void log(String nameTest, Object expected) {
        log.info(System.lineSeparator() +
                "Test:{}" + System.lineSeparator() +
                "Expected:{}" + System.lineSeparator(), nameTest, expected);
    }
//    /**
//     * Проверяет что статусы продаж это обьекты, а не null
//     */
//    @Test
//    void checkForNullOfSaleStatuses() {
//        List<SaleStatusDto> allSaleStatuses = dictionaryClient.getAllSaleStatuses();
//        Assertions.assertTrue(allSaleStatuses.stream().noneMatch(Objects::isNull));
//        log.debug(allSaleStatuses.toString());
//    }
//
//    /**
//     * Проверяет OPEN статус продажи
//     */
//    @Test
//    void getSaleStatusById() {
//        SaleStatusDto saleStatusDtoExpected = SaleStatusDtoTest.getOpenInstance();
//        SaleStatusDto saleStatusByIdActual = dictionaryClient.getSaleStatusById(saleStatusDtoExpected.getSstatId());
//        Assertions.assertEquals(saleStatusDtoExpected, saleStatusByIdActual);
//        log.debug("{} ? {}", saleStatusDtoExpected, saleStatusByIdActual);
//    }
}