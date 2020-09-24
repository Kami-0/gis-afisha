package ru.kami.gis.afisha.commons;

import feign.Feign;
import feign.Logger;
import feign.gson.GsonEncoder;
import feign.slf4j.Slf4jLogger;
import ru.kami.gis.afisha.commons.decoders.InstantGsonDecoder;

/**
 * @author Daniil.Makarov
 */
public final class FeignClientBuilder {
    public static <T> T createClient(Class<T> type, String uri) {
        return Feign.builder()
                .logger(new Slf4jLogger())
                .logLevel(Logger.Level.FULL)
                .encoder(new GsonEncoder())
                .decoder(new InstantGsonDecoder())
                .target(type, uri);
    }
}
