package org.yoti.yotitechnicaltest.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yoti.yotitechnicaltest.models.HooverRequest;
import org.yoti.yotitechnicaltest.models.HooverResult;
import org.yoti.yotitechnicaltest.models.RoboticHoover;
import org.yoti.yotitechnicaltest.models.Room;

@RestController
@RequestMapping("/")
public class RoboticHooverController {

    private RoboticHoover notRoomba = new RoboticHoover(); //for copyright purposes this robotic hoover is not Roomba
    private Room room = new Room();

    @PostMapping
    @RequestMapping("/hoover")
    public HooverResult doHoovering(@RequestBody HooverRequest hooverRequest) {

        return new HooverResult();
    }

}
