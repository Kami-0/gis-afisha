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
public class PlaceEntity {
    private Long id;
    private Long row;
    private Long place;
    private Long hallId;
}
