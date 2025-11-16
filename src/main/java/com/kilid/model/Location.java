package com.kilid.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.*;

@Entity
@Getter
@Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    private String city ;
    private String distract ;
    private String neighborhood ;

    @OneToMany(mappedBy = "location" ,cascade = CascadeType.ALL)
    private List<Property> properties ;
}
