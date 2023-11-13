package com.example.eksamenprep;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class Vet{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vet_seq_gen")
    @SequenceGenerator(name = "vet_seq_gen", sequenceName = "vet_seq", initialValue = 1, allocationSize = 1)
    @Column(name = "VetId")
    private Long vetId =0L;
    @Column(name = "VetName")
    private String vetName;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "VetId")
    private List<Appointment> appointment = new ArrayList<>();

    public Vet(String vetName) {
        this.vetName = vetName;
    }
}