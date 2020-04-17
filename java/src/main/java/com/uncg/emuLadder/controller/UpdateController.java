package com.uncg.emuLadder.controller;

import com.uncg.emuLadder.service.bl.UpdatePointsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/update")
public class UpdateController {

    private final UpdatePointsService updatePointsService;

    /**
     * Update the event points table with values from League Stats
     */
    @GetMapping("/points")
    public boolean updatePoints() {
        return updatePointsService.updatePoints();
    }

    @Autowired
    public UpdateController(final UpdatePointsService updatePointsService) {
        this.updatePointsService = updatePointsService;
    }
}
