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
public class PlaceInfoDto {
    /**
     * Индитификатор места в базе данных
     */
    @NotNull
    private Long id;
    /**
     * Номер ряда в зале
     */
    @NotNull
    private Long row;
    /**
     * Номер места в зале
     */
    @NotNull
    private Long place;
    /**
     * Индитификатор зала которому принадлежит место
     */
    @NotNull
    private Long hallId;
    /**
     * Свободно/забронированно место
     */
    @NotNull
    private Boolean isFree;
}
