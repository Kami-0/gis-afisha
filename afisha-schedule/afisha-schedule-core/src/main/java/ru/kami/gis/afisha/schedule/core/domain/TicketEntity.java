package ru.kami.gis.afisha.schedule.core.domain;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Daniil.Makarov
 */
@Setter
@NoArgsConstructor
@ToString
public class TicketEntity {
    private Long id;
    private Long eventId;
    private Long placeId;
    private Boolean isActs;

    public TicketEntity(Long id, Long eventId, Long placeId, Boolean isActs) {
        this.id = id;
        this.eventId = eventId;
        this.placeId = placeId;
        this.isActs = isActs;
    }

    public Long getId() {
        return id;
    }

    public Long getEventId() {
        return eventId;
    }

    public Long getPlaceId() {
        return placeId;
    }

    public Boolean isActs() {
        return isActs;
    }
}
