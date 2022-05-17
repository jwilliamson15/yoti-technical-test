package org.yoti.yotitechnicaltest.models;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.yoti.yotitechnicaltest.converters.CoordinateConverter;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "hoover_results")
public class HooverResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hoover_id;

    @Column(name = "final_position")
    @Convert(converter = CoordinateConverter.class)
    private Coordinate coords;

    @Column(name = "patches_cleaned")
    private Integer patches = 0;
}
