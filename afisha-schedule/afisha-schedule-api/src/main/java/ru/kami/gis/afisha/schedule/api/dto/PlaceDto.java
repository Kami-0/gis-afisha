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
public class PlaceDto {
    /**
     * Индитификатор места в базе данных
     */
    @NotNull
    private Long id;
    /**
     * Номер места в зале
     */
    @NotNull
    private Long number;
    /**
     * Стоимость места в рублях
     */
    @NotNull
    private Double price;
    /**
     * Статус свободно/занято
     */
    @NotNull
    private Boolean isFree;
}
