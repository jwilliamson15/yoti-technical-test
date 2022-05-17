package org.yoti.yotitechnicaltest.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.yoti.yotitechnicaltest.converters.CoordinateConverter;
import org.yoti.yotitechnicaltest.converters.PatchesConverter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "hoover_requests")
public class HooverRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hoover_id;

    @Column(name = "room_size")
    @Convert(converter = CoordinateConverter.class)
    private Coordinate roomSize;

    @Column(name = "start_position")
    @Convert(converter = CoordinateConverter.class)
    private Coordinate coords;

    @Column(name = "patches")
    @Convert(converter = PatchesConverter.class)
    private List<Coordinate> patches;

    @Column(name = "instructions")
    private String instructions;

    public HooverRequest(Coordinate roomSize, Coordinate coords,
                         List<Coordinate> patches, String instructions) {
        this.roomSize = roomSize;
        this.coords = coords;
        this.patches = patches;
        this.instructions = instructions;
    }
}
