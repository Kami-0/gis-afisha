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
public class EventDto {
    /**
     * Индитификатор события в базе данных
     */
    @NotNull
    private Long id;
    /**
     * Название события
     */
    @NotNull
    private Long name;
    /**
     * Возрастное ограничение события
     */
    @NotNull
    private Long ageRestriction;
    /**
     * Длительность события в минутах
     */
    @NotNull
    private Long duration;
}
