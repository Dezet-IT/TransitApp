package pl.dezet.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.dezet.model.Transit;
import pl.dezet.service.TransitService;

import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/transit")
public class TransitController {
    private TransitService transitService;

    @Autowired
    public void setTransitService(TransitService transitService) {
        this.transitService = transitService;
    }


    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addTransit(@RequestBody Transit transit) {
        transitService.calculateDistance(transit);
        transitService.addTransit(transit);
        System.out.println(transit);
    }

    @RequestMapping(path = "reports/daily", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void getDailyReport(@RequestParam("startDate") Date startDate, @RequestParam("endDate") Date endDate) {
        double totalDistance = 0.0;
        double totalPrice = 0.0;
        List<Transit> transits = transitService.getTransits(startDate, endDate);
        for (int i = 0; i < transits.size(); i++) {
            totalDistance = totalDistance + transits.get(i).getDistance();
            totalPrice = totalPrice + transits.get(i).getPrice();
        }

    }


}
