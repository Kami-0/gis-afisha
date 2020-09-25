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
public class CinemaHallEntity {
    private Long id;
    private Long number;
    private Long placesNumber;
    private Long cinemaId;
}
