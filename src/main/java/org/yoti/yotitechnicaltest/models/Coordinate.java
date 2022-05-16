package org.yoti.yotitechnicaltest.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.ARRAY)
@JsonPropertyOrder({"x","y"})
public class Coordinate {
    private Integer x;
    private Integer y;

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Coordinate)) {
            return false;
        }

        Coordinate coordObj = (Coordinate) o;
        return Integer.compare(x, coordObj.x) == 0
            && Integer.compare(y, coordObj.y) == 0;
    }
}
