package ru.kami.gis.afisha.commons.decoders;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import feign.gson.GsonDecoder;

import java.time.Instant;

/**
 * @author Daniil.Makarov
 */
public class InstantGsonDecoder extends GsonDecoder {
    public InstantGsonDecoder() {
        super(new GsonBuilder()
                .registerTypeAdapter(Instant.class,
                        (JsonDeserializer<Instant>) (json, type, jsonDeserializationContext) ->
                                Instant.parse(json.getAsJsonPrimitive().getAsString())).create());
    }
}
