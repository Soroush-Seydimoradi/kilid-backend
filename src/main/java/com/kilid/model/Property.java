package com.kilid.model;

import jakarta.persistence.*;
import lombok.*;
import org.locationtech.jts.geom.Point;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private Double area;
    private BigDecimal price;
    private Integer rooms;
    private Integer builtYear;

    @Enumerated(EnumType.STRING)
    private PropertyType propertyType;

    private String address;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL)
    private List<Image> images;

    @ManyToMany
    @JoinTable(
            name = "property_features",
            joinColumns = @JoinColumn(name = "property_id"),
            inverseJoinColumns = @JoinColumn(name = "feature_id")
    )
    private List<Feature> features;

    @Column(columnDefinition = "geometry(Point,4326)")
    private Point coordinates;
}