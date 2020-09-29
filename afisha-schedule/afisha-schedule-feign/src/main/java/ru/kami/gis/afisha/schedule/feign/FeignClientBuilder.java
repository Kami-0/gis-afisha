package ru.kami.gis.afisha.schedule.feign;

import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.slf4j.Slf4jLogger;

/**
 * @author Daniil.Makarov
 */
public final class FeignClientBuilder {
    public static <T> T createClient(Class<T> type, String uri) {
        return Feign.builder()
                .logger(new Slf4jLogger())
                .logLevel(Logger.Level.FULL)
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .target(type, uri);
    }
}
