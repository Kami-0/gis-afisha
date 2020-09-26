package ru.kami.gis.afisha.schedule.api.dto;

import lombok.*;

import javax.validation.constraints.NotNull;

/**
 * @author Daniil.Makarov
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Builder
@EqualsAndHashCode
public class TicketDto {
    /**
     * Индитификатор билета
     */
    @NotNull
    private Long id;
    /**
     * Индитификатор события
     */
    @NotNull
    private Long eventId;
    /**
     * Индитификатор места
     */
    @NotNull
    private Long placeId;
    /**
     * Флаг валидности билета
     */
    @NotNull
    private String isActs;
}
