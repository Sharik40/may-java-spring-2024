package org.example.mayjavaspring2024.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String model;

    private Long enginePower;

    @Column(name = "torque")
    private Double torque;
}
