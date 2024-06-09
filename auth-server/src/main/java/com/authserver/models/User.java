package com.authserver.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Table(name="\"user\"")
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID userId;

    private String userName;
    private String password;
    private Boolean isVerified;

    private String email;
    private String firstName;
    private String lastName;
    private String phone;

}
