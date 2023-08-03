package com.caching.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cache_details")
public class CacheEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "ID")
    private int id;

    @Column(name = "NAME")
    private String name;

   // @Column(name = "Roll_NO")
    private int rollNo;

    @Column(name = "LOCATION")
    private String location;
}
