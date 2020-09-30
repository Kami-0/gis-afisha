package ru.kami.gis.afisha.schedule.feign.client;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.kami.gis.afisha.schedule.feign.FeignClientBuilder;
import ru.kami.gis.afisha.schedule.feign.OrderApiFeign;
import ru.kami.gis.afisha.schedule.feign.ScheduleApiFeign;

/**
 * @author Daniil.Makarov
 */
@Getter
@Configuration
public class ControllerFeignClients {

    @Value("${server.uri}")
    private String uri;

    @Bean
    public ScheduleApiFeign scheduleClient() {
        return FeignClientBuilder.createClient(ScheduleApiFeign.class, uri);
    }

    @Bean
    public OrderApiFeign orderClient() {
        return FeignClientBuilder.createClient(OrderApiFeign.class, uri);
    }
}

