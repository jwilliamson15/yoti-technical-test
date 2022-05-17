package org.yoti.yotitechnicaltest.converters;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.AttributeConverter;

import org.yoti.yotitechnicaltest.models.Coordinate;

public class PatchesConverter implements AttributeConverter<List<Coordinate>, String> {


    @Override
    public String convertToDatabaseColumn(List<Coordinate> coordinates) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Coordinate coordinate : coordinates) {
            stringBuilder.append(String.format("%s:%s,", coordinate.getX(), coordinate.getY()));
        }

        String coordinateString = stringBuilder.toString();
        if (coordinateString.isEmpty()) {
            return "";
        }

        return coordinateString.substring(0, coordinateString.length() - 1);
    }

    @Override
    public List<Coordinate> convertToEntityAttribute(String coordinatesString) {
        List<Coordinate> patchesList = new ArrayList<>();
        for (String coordinateString : coordinatesString.split(",")) {
            if (coordinateString.equals("")) {
                return patchesList;
            }

            String[] coordinateArray = coordinateString.split(":");
            Coordinate coordinate = new Coordinate(Integer.parseInt(coordinateArray[0]),
                Integer.parseInt(coordinateArray[1]));
            patchesList.add(coordinate);
        }

        return patchesList;
    }
}
