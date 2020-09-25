package ru.kami.gis.afisha.schedule.core.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Daniil.Makarov
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EventEntity {
    private Long id;
    private Long hallId;
    private String name;
    private Long ageRestriction;
    private Long duration;
}
