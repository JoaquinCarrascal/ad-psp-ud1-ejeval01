package com.salesianostriana.dam.resteval;

import lombok.Builder;

import java.util.List;

@Builder
public record GetAllPlacesDto(

        int placesCount,
        List<GetPlaceDto> placeDtoList

) {

    public static GetAllPlacesDto of (List<Place> list){

        return GetAllPlacesDto.builder()
                .placesCount(list.size())
                .placeDtoList(list.stream().map(GetPlaceDto::of).toList()).build();

    }

}
