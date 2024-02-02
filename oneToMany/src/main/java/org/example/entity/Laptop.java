package org.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@AllArgsConstructor@NoArgsConstructor
@Getter@Setter
@ToString
public class Laptop {
    @Id
    private int LapId;
    private String model;
    @ManyToOne
    private Student student;
}
