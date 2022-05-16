package org.yoti.yotitechnicaltest.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.creation.settings.CreationSettings;
import org.springframework.test.context.junit4.SpringRunner;
import org.yoti.yotitechnicaltest.models.Coordinate;
import org.yoti.yotitechnicaltest.models.HooverRequest;
import org.yoti.yotitechnicaltest.models.HooverResult;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
class HooverServiceTest {

    private static HooverService hooverService = new HooverService();

    @Before
    public void setUp() {

    }

    @Test
    public void moveHooverNorth() {
        HooverRequest request = new HooverRequest(
            new Coordinate(3,3),
            new Coordinate(0,0),
            new ArrayList<>(),
            "N"
        );

        HooverResult result = hooverService.doTheHoovering(request);

        assertEquals(1, result.getCoords().getY().intValue());
    }

    @Test
    public void moveHooverNorthMultiple() {
        HooverRequest request = new HooverRequest(
            new Coordinate(3,3),
            new Coordinate(0,0),
            new ArrayList<>(),
            "NNN"
        );

        HooverResult result = hooverService.doTheHoovering(request);

        assertEquals(3, result.getCoords().getY().intValue());
    }

    @Test
    public void moveHooverEast() {
        HooverRequest request = new HooverRequest(
            new Coordinate(3,3),
            new Coordinate(0,0),
            new ArrayList<>(),
            "E"
        );

        HooverResult result = hooverService.doTheHoovering(request);

        assertEquals(1, result.getCoords().getX().intValue());
    }

    @Test
    public void moveHooverSouth() {
        HooverRequest request = new HooverRequest(
            new Coordinate(3,3),
            new Coordinate(0,1),
            new ArrayList<>(),
            "S"
        );

        HooverResult result = hooverService.doTheHoovering(request);

        assertEquals(0, result.getCoords().getY().intValue());
    }

    @Test
    public void moveHooverWest() {
        HooverRequest request = new HooverRequest(
            new Coordinate(3,3),
            new Coordinate(1,0),
            new ArrayList<>(),
            "W"
        );

        HooverResult result = hooverService.doTheHoovering(request);

        assertEquals(0, result.getCoords().getY().intValue());
    }

    @Test
    public void moveHooverMultiple() {
        HooverRequest request = new HooverRequest(
            new Coordinate(3,3),
            new Coordinate(0,1),
            new ArrayList<>(),
            "NESS"
        );

        HooverResult result = hooverService.doTheHoovering(request);

        assertEquals(1, result.getCoords().getX().intValue());
        assertEquals(0, result.getCoords().getY().intValue());
    }

    @Test
    public void dontMoveAgainstWallSouth() {
        HooverRequest request = new HooverRequest(
            new Coordinate(3,3),
            new Coordinate(0,0),
            new ArrayList<>(),
            "S"
        );

        HooverResult result = hooverService.doTheHoovering(request);

        assertEquals(0, result.getCoords().getY().intValue());
    }

    @Test
    public void dontMoveAgainstWallNorth() {
        HooverRequest request = new HooverRequest(
            new Coordinate(3,3),
            new Coordinate(0,3),
            new ArrayList<>(),
            "N"
        );

        HooverResult result = hooverService.doTheHoovering(request);

        assertEquals(3, result.getCoords().getY().intValue());
    }

    @Test
    public void dontMoveAgainstWallWest() {
        HooverRequest request = new HooverRequest(
            new Coordinate(3,3),
            new Coordinate(0,0),
            new ArrayList<>(),
            "W"
        );

        HooverResult result = hooverService.doTheHoovering(request);

        assertEquals(0, result.getCoords().getY().intValue());
    }

    @Test
    public void dontMoveAgainstWallEast() {
        HooverRequest request = new HooverRequest(
            new Coordinate(3,3),
            new Coordinate(3,0),
            new ArrayList<>(),
            "E"
        );

        HooverResult result = hooverService.doTheHoovering(request);

        assertEquals(3, result.getCoords().getX().intValue());
    }

    @Test
    public void dontMoveAgainstWallMultiple() {
        HooverRequest request = new HooverRequest(
            new Coordinate(3,3),
            new Coordinate(3,3),
            new ArrayList<>(),
            "SSSSWWWW"
        );

        HooverResult result = hooverService.doTheHoovering(request);

        assertEquals(0, result.getCoords().getX().intValue());
        assertEquals(0, result.getCoords().getY().intValue());
    }

    @Test
    public void cleanOnePatch() {
        List<Coordinate> patches = new ArrayList<>();
        patches.add(new Coordinate(0,1));
        HooverRequest request = new HooverRequest(
            new Coordinate(3,3),
            new Coordinate(0,0),
            patches,
            "N"
        );

        HooverResult result = hooverService.doTheHoovering(request);

        assertEquals(1, result.getPatches().intValue());
    }

    @Test
    public void cleanMultiplePatchesLinear() {
        List<Coordinate> patches = new ArrayList<>();
        patches.add(new Coordinate(0,1));
        patches.add(new Coordinate(0,2));
        HooverRequest request = new HooverRequest(
            new Coordinate(3,3),
            new Coordinate(0,0),
            patches,
            "NN"
        );

        HooverResult result = hooverService.doTheHoovering(request);

        assertEquals(2, result.getPatches().intValue());
    }

    @Test
    public void cleanMultiplePatchesNonLinear() {
        List<Coordinate> patches = new ArrayList<>();
        patches.add(new Coordinate(0,1));
        patches.add(new Coordinate(1,1));
        HooverRequest request = new HooverRequest(
            new Coordinate(3,3),
            new Coordinate(0,0),
            patches,
            "NE"
        );

        HooverResult result = hooverService.doTheHoovering(request);

        assertEquals(2, result.getPatches().intValue());
    }

}