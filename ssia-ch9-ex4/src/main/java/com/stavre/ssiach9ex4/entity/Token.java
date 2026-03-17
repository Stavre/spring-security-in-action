package com.stavre.ssiach9ex4.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String identifier;
    private String token;
}
