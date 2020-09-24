package ru.kami.gis.afisha.schedule.api.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
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
public class CinemaDto {
    /**
     * Индитификатор кинотеатра в базе данных
     */
    @NotNull
    private Long id;
    /**
     * Название кинотеатра
     */
    @NotBlank
    private String name;
}
