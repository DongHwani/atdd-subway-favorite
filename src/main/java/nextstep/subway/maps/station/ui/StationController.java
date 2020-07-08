package nextstep.subway.maps.station.ui;

import nextstep.subway.maps.station.domain.Station;
import nextstep.subway.maps.station.domain.StationRepository;
import nextstep.subway.maps.station.dto.StationCreateRequest;
import nextstep.subway.maps.station.dto.StationResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
public class StationController {
    private StationRepository stationRepository;

    public StationController(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    @PostMapping("/stations")
    public ResponseEntity createStation(@RequestBody StationCreateRequest view) {
        Station station = view.toStation();
        try {
            Station persistStation = stationRepository.save(station);
            return ResponseEntity.created(URI.create("/stations/" + persistStation.getId())).body(StationResponse.of(persistStation));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping(value = "/stations", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity showStations() {
        return ResponseEntity.ok().body(stationRepository.findAll());
    }

    @DeleteMapping("/stations/{id}")
    public ResponseEntity deleteStation(@PathVariable Long id) {
        stationRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
