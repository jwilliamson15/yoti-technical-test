package org.yoti.yotitechnicaltest.models;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class HooverRequest {
    private Coordinate roomSize;
    private Coordinate coords;
    private List<Coordinate> patches;
    private String instructions;
}
