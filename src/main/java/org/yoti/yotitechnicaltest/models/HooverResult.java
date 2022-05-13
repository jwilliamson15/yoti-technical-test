package org.yoti.yotitechnicaltest.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class HooverResult {
    private Integer hooverXPosition = 0;
    private Integer hooverYPosition = 0;
    private Integer patchesCleaned = 0;
}
