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
    public List<Transit> getDailyReport(@RequestParam("startDate") Date startDate){
        List<Transit> transits = transitService.getTransitsWithDateAfter(startDate);
        System.out.println(transits.get(0));
        return transits;
    }

   /* @RequestMapping(path = "reports/daily", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
        public void getDailyReport(@RequestParam("startDate") DateTime startDate, @RequestParam("endDate") DateTime endDate){
        List<Transit> transits = transitService.getTransits();
        Double totalPrice = 0.0;
        Double totalDistance = 0.0;
        for (int i = 0; i < transits.size() ; i++) {
            totalPrice = totalPrice + transits.get(i).getPrice();
            totalDistance = totalDistance + transits.get(i).getDistance();
        }

    }*/

}
