package com.example.eksamenprep;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appointment_seq_gen")
    @SequenceGenerator(name="appointment_seq_gen", sequenceName="appointment_seq", allocationSize = 1)
    @Column(name = "AppointmentId")
    private Long appointmentId = 0L;

    @Column(name = "AppointmentDate")
    private LocalDateTime appointmentDate;

    @Column(name = "AppointmentDuration")
    private Long appointmentDuration = 0L;

    @ManyToOne
    @JoinColumn(name = "PetId")
    @JsonIgnoreProperties("appointments")
    private Pet pet;

    @ManyToOne
    @JsonIgnoreProperties("appointments")
    @JoinColumn(name = "VetId")
    private Vet vet;

    @ManyToOne
    @JoinColumn(name = "RoomId")
    private Room room;






}