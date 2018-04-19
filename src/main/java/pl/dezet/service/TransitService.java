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

import java.util.Date;
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

        DistanceMatrix result = request.origins(transit.getSourceAddress())
                .destinations(transit.getDestinationAddress())
                .mode(TravelMode.DRIVING)
                .units(Unit.METRIC)
                .awaitIgnoreError();

        long distance = result.rows[0].elements[0].distance.inMeters;
        transit.setDistance(distance);

    }

    public List<Transit> getTransits(Date startDate, Date endDate) {
        List<Transit> transits = transitRepository.find(startDate, endDate);
        return transits;
    }


}
