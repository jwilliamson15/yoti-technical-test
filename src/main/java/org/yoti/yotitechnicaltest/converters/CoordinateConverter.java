package org.yoti.yotitechnicaltest.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.yoti.yotitechnicaltest.models.Coordinate;

@Converter
public class CoordinateConverter implements AttributeConverter<Coordinate, String> {

    @Override
    public String convertToDatabaseColumn(Coordinate coordinate) {

        return String.format("%s:%s", coordinate.getX(), coordinate.getY());
    }

    @Override
    public Coordinate convertToEntityAttribute(String coordinateString) {
        String[] pointArray = coordinateString.split(":");

        return new Coordinate(Integer.parseInt(pointArray[0]), Integer.parseInt(pointArray[1]));
    }
}
