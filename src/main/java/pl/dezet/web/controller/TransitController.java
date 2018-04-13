package pl.dezet.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.dezet.model.Transit;
import pl.dezet.service.TransitService;


@RestController
public class TransitController {
    private TransitService transitService;

    @Autowired
    public void setTransitService(TransitService transitService) {
        this.transitService = transitService;
    }

    @GetMapping("/transit")
    public String register(Model model) {
        model.addAttribute("user", new Transit());
        return "addTransitForm";
    }

    @RequestMapping(path = "/transit", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addTransit(@RequestBody Transit transit){
        transitService.calculateDistance(transit);
        transitService.addTransit(transit);
        System.out.println(transit);
    }
}
