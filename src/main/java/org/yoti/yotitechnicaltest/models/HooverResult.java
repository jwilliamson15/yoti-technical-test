package org.yoti.yotitechnicaltest.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class HooverResult {
    private Coordinate coords;
    private Integer patches = 0;
}
