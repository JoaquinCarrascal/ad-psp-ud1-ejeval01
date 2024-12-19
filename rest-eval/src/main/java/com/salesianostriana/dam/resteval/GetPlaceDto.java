package com.salesianostriana.dam.resteval;

import lombok.Builder;

@Builder
public record GetPlaceDto(

        Long id,
        String name,
        String coords,
        String img

) {

    public static GetPlaceDto of(Place p){

        return GetPlaceDto.builder()
                .id(p.getId())
                .name(p.getName())
                .coords(p.getCoords())
                .img(p.getImage()).build();
    }


}
