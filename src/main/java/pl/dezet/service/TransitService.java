package pl.dezet.service;


import com.google.maps.DistanceMatrixApi;
import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.TravelMode;
import com.google.maps.model.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dezet.model.Transit;
import pl.dezet.repository.TransitRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class TransitService {

    private TransitRepository transitRepository;
    public static final String API_KEY = "AIzaSyBlJos2RY_SBYeQIKWQJdwEN_2VnJhRY-0";

    @Autowired
    public void setTransitRepository(TransitRepository transitRepository) {
        this.transitRepository = transitRepository;
    }

    public void addTransit(Transit transit) {
        transitRepository.save(transit);
    }

    public void calculateDistance(Transit transit) {

        GeoApiContext geoApiContext = new GeoApiContext.Builder().apiKey(API_KEY).build();
        DistanceMatrixApiRequest request = DistanceMatrixApi.newRequest(geoApiContext);

        try {
            DistanceMatrix result = request.origins(transit.getSourceAddress())
                    .destinations(transit.getDestinationAddress())
                    .mode(TravelMode.DRIVING)
                    .units(Unit.METRIC)
                    .awaitIgnoreError();

            long distance = (result.rows[0].elements[0].distance.inMeters) / 1000;
            transit.setDistance(distance);
        } catch (NullPointerException e) {
            e.fillInStackTrace().getMessage();
        }


    }

    public List<Transit> getTransits(LocalDate startDate, LocalDate endDate) {
        List<Transit> transits = transitRepository.find(startDate, endDate);
        for (int i = 0; i < transits.size(); i++) {
            System.out.println(transits.get(i).toString());
        }
        return transits;
    }


}
