package org.yoti.yotitechnicaltest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yoti.yotitechnicaltest.models.HooverRequest;
import org.yoti.yotitechnicaltest.models.HooverResult;
import org.yoti.yotitechnicaltest.service.DatabaseService;
import org.yoti.yotitechnicaltest.service.HooverService;

@RestController
@RequestMapping("/")
public class RoboticHooverController {

    @Autowired
    private HooverService hooverService;

    @Autowired
    DatabaseService databaseService;

    @PostMapping
    @RequestMapping("/hoover")
    public HooverResult hooveringRequest(@RequestBody final HooverRequest hooverRequest) {
        databaseService.saveRequest(hooverRequest);

        HooverResult result = hooverService.doTheHoovering(hooverRequest);

        databaseService.saveResult(result);

        return result;
    }

}
