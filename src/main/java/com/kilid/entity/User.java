package com.kilid.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "users")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;

    private String  fullName;

    @Column(unique = true , nullable = false)
    private String email ;

    private String password ;
    private String phone ;

    @Enumerated(EnumType.STRING)
    private UserRole role ;

    private LocalDateTime createdAt = LocalDateTime.now() ;

    @OneToMany(mappedBy = "user" , cascade = CascadeType.ALL)
    private List<Listing> listing ;

    @OneToMany(mappedBy = "sender" , cascade = CascadeType.ALL)
    private List<Inquiry> inquiries ;

}
