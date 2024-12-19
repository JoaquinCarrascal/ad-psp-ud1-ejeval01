package com.salesianostriana.dam.resteval;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/place/")
public class PlaceController {

    private final PlaceService placeServ;

    @GetMapping("{id}")
    public GetPlaceDto getPlace(@PathVariable Long id){

        return GetPlaceDto.of(placeServ.getPlace(id));

    }

    @GetMapping
    public GetAllPlacesDto getAllPlaces(){

        return GetAllPlacesDto.of(placeServ.getAllPlaces());

    }

    @PostMapping
    public ResponseEntity<Place> create(@RequestBody CreatePlaceDto cPDto){

        return ResponseEntity.status(201).body(placeServ.create(cPDto.toPlace()));

    }


}
