package com.salesianostriana.dam.resteval;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequiredArgsConstructor
@RequestMapping("/place/")
public class PlaceController {

    private final PlaceRepository placeRep;
    private final GetPlaceDto getAllPlDto;

    @GetMapping
    public ResponseEntity<List<Place>> getAll(){

        List <Place> result = placeRep.getAll();

        if(result.isEmpty())
            return new ResponseEntity<List<Place>>(NOT_FOUND);
        else
            return ResponseEntity.ok(result);
    }

    @GetMapping("{id}")
    public ResponseEntity<Place> getById(@PathVariable Long id){

        Optional<Place> optPlace = placeRep.get(id);

        return optPlace.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(NOT_FOUND));

    }

    @PostMapping
    public ResponseEntity<Place> createPlace(@RequestBody Place p){

        Place newPlace = placeRep.add(p);

        return new ResponseEntity<Place>(newPlace,CREATED);

    }

    @PutMapping("{id}")
    public ResponseEntity<Place> edit(@PathVariable Long id , @RequestBody Place p) {

        return placeRep.edit(id, p).map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(NOT_FOUND));

    }

    ///place/{id}/tag/
    //add/{nuevo_tag}
    /*@PutMapping("{id}/tag/add/{newTag}")
    public ResponseEntity<Place> addTag(){



    }*/

}
