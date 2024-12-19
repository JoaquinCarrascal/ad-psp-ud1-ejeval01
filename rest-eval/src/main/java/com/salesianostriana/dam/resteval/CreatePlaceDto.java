package com.salesianostriana.dam.resteval;

public record CreatePlaceDto(

       String name,
       String address,
       String coords,
       String desc,
       String image

) {

    public Place toPlace(){
        return Place.builder()
                .name(this.name)
                .address(this.address)
                .coords(this.coords)
                .desc(this.desc)
                .image(this.image)
                .build();
    }

}
