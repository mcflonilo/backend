package com.example.eksamenprep.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter @NoArgsConstructor @Entity
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pet_seq_gen")
    @SequenceGenerator(name="pet_seq_gen", sequenceName="pet_seq", allocationSize = 1)
    @Column(name = "PetId")
    private Long petId = 0L;

    @Column(name = "PetName")
    private String petName;

    @Column(name = "PetType")
    private String petType;

    @ManyToOne
    @JoinColumn(name = "CustomerId")
    private Customer customer;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "PetId")
    private List<Appointment> appointments = new ArrayList<>();

    public Pet(String petName, String petType) {
        this.petName = petName;
        this.petType = petType;
    }
}
