package com.kilid.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Listing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user ;

    @OneToOne
    @JoinColumn(name = "property_id")
    private Property property ;

    @Enumerated(EnumType.STRING)
    private ListingType type ;

    @Enumerated(EnumType.STRING)
    private ListingStatus status ;

    private LocalDateTime createdAt = LocalDateTime.now() ;
    private LocalDateTime updatedAt = LocalDateTime.now() ;

    @OneToMany(mappedBy = "listing" , cascade = CascadeType.ALL)
    private List<Inquiry> inquiries ;

}
