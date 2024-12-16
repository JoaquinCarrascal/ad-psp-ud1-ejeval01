package com.salesianostriana.dam.resteval;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public record GetAllPlacesDto(

        List<GetPlaceDto> placesList

) {

    @Autowired
    public static GetPlaceDto getPDto;

    /*public GetAllPlacesDto toAllPlacesDto(List<Place> list){

        List<Place> newList = List.of();

        return list.forEach(x -> newList.add(getPDto.toPlaceDto(x)));

    }*/

}
