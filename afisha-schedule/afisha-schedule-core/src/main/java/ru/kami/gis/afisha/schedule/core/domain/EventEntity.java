package ru.kami.gis.afisha.schedule.core.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Daniil.Makarov
 */
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EventEntity {
    private Long id;
    private Long hallId;
    private String name;
    private Long ageRestriction;
    private Long duration;

    public Long getId() {
        return id;
    }

    public Long getHallId() {
        return hallId;
    }

    public String getName() {
        return name;
    }

    public Long getAgeRestriction() {
        return ageRestriction;
    }

    public Long getDuration() {
        return duration;
    }
}
