package com.kilid.model;

import jakarta.persistence.*;
import lombok.*;
import org.locationtech.jts.geom.Point;

import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city;
    private String district;
    private String neighborhood;


    @Column(columnDefinition = "geometry(Point,4326)")
    private Point coordinates;

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
    private List<Property> properties;
}