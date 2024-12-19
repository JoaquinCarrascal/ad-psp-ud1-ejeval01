package com.salesianostriana.dam.resteval;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlaceService {

    private final PlaceRepository placeRepo;

    public Place getPlace(Long id){
        return placeRepo.get(id).orElseThrow(
                () -> new PlaceNotFoundException("No se encuentra dicho establecimiento.")
        );
    }

    public List<Place> getAllPlaces(){

        List<Place> listP = placeRepo.getAll();

        if(listP.isEmpty())
            throw new PlaceNotFoundException("No se ha encontrado ningún establecimiento.");

        return listP;

    }

    public Place create(Place p){

        return placeRepo.add(p);

    }


}
