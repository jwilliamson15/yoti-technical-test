package org.yoti.yotitechnicaltest.models;

import java.util.List;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class HooverRequest {

    private Coordinate roomSize;
    private Coordinate coords;
    private List<Coordinate> patches;
    private String instructions;
}
