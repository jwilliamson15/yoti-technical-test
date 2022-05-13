package org.yoti.yotitechnicaltest.models;

import java.util.HashMap;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Room {
    private Integer roomXDimension;
    private Integer roomYDimension;

    private HashMap<Integer, Integer> dirtPatches;

}
