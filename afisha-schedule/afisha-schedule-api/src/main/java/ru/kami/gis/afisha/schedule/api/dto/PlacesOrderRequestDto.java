package ru.kami.gis.afisha.schedule.api.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author Daniil.Makarov
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Builder
@EqualsAndHashCode
public class PlacesOrderRequestDto {
    /**
     * Индитификатор ивента
     */
    @NotNull
    private Long eventId;

    /**
     * Индитификатор места
     */
    @NotNull
    private List<Long> placesId;
}
