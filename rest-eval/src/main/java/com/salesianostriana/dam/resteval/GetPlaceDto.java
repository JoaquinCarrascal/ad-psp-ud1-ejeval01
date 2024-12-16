package com.salesianostriana.dam.resteval;

import lombok.Builder;

@Builder
public record GetPlaceDto(

        Long id,
        String name,
        String address,
        String coords,
        String desc,
        String tags,
        String image

) {

    public GetPlaceDto toPlaceDto(Place p){

        return GetPlaceDto.builder()
                .id(p.getId())
                .name(p.getName())
                .address(p.getAddress())
                .coords(p.getCoords())
                .desc(p.getDesc())
                .tags(String.join(" ", p.getTags()))
                .image(p.getImage()).build();

    }

}
