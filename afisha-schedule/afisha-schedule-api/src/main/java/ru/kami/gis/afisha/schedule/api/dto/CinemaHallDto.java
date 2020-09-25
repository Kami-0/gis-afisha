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
public class CinemaHallDto {
    /**
     * Индитификатор зала в базе данных
     */
    @NotNull
    private Long id;
    /**
     * Номер зала в кинотеатре
     */
    @NotNull
    private Long number;
    /**
     * Количество мест в зале
     */
    @NotNull
    private Long placesNumber;
    /**
     * Индитификатор кинотеатра
     */
    @NotNull
    private Long cinemaId;
}
