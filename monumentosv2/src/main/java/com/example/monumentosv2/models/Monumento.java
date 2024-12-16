package com.example.monumentosv2.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Monumento {

    private Long id;
    private String countryCode;
    private String countryName;
    private String cityName;
    private Double latitude;
    private Double longitude;
    private String name;
    private String description;
    private String image;
}
