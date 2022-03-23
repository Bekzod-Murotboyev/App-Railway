package com.example.rail_e_ticket_front.feign;

import com.example.rail_e_ticket_front.model.Car;
import com.example.rail_e_ticket_front.model.Destination;
import com.example.rail_e_ticket_front.model.Station;
import com.example.rail_e_ticket_front.model.Train;
import com.example.rail_e_ticket_front.payload.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import static com.example.rail_e_ticket_front.utils.interfaces.Url.*;

@FeignClient(url = URL_GLOBAL, name = "railwayFeign")
public interface RailwayFeign {

    @GetMapping(URL_STATION)
    ApiResponse getStations(@RequestHeader String authorization);

    @PostMapping(URL_STATION)
    ApiResponse addStation(@RequestBody Station station,@RequestHeader String authorization);

    @PutMapping(URL_STATION+"/{id}")
    ApiResponse editStation(@PathVariable Long id,@RequestBody Station station,@RequestHeader String authorization);

    @DeleteMapping(URL_STATION+"/{id}")
    void deleteStation(@PathVariable Long id,@RequestHeader String authorization);

    @GetMapping(URL_DESTINATION)
    ApiResponse getDestinations(@RequestHeader String authorization);

    @PostMapping(URL_DESTINATION)
    ApiResponse addDestination(@RequestBody Destination destination,@RequestHeader String authorization);

    @PutMapping(URL_DESTINATION+"/{id}")
    ApiResponse editDestination(@PathVariable Long id,@RequestBody Destination destination,@RequestHeader String authorization);

    @DeleteMapping(URL_DESTINATION+"/{id}")
    void deleteDestination(@PathVariable Long id,@RequestHeader String authorization);

    @GetMapping(URL_TRAIN)
    ApiResponse getTrains(@RequestHeader String authorization);

    @PostMapping(URL_TRAIN)
    ApiResponse addTrain(@RequestBody Train train,@RequestHeader String authorization);

    @PutMapping(URL_TRAIN+"/{id}")
    ApiResponse editTrain(@PathVariable Long id,@RequestBody Train train,@RequestHeader String authorization);

    @DeleteMapping(URL_TRAIN+"/{id}")
    void deleteTrain(@PathVariable Long id,@RequestHeader String authorization);

    @GetMapping(URL_CAR)
    ApiResponse getCars(@RequestHeader String authorization);

    @PostMapping(URL_CAR)
    ApiResponse addCar(@RequestBody Car car,@RequestHeader String authorization);

    @PutMapping(URL_CAR+"/{id}")
    ApiResponse editCar(@PathVariable Long id,@RequestBody Car car,@RequestHeader String authorization);

    @DeleteMapping(URL_CAR+"/{id}")
    void deleteCar(@PathVariable Long id,@RequestHeader String authorization);
}
