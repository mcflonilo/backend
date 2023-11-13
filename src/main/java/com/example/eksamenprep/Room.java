package com.example.eksamenprep;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter @NoArgsConstructor @Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "room_seq_gen")
    @SequenceGenerator(name="room_seq_gen", sequenceName="room_seq", allocationSize = 1)
    @Column(name = "RoomId")
    private Long roomId = 0L;

    @Column(name = "RoomName")
    private String roomName;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "RoomId")
    private List<Appointment> appointments = new ArrayList<>();

    public Room(String roomName) {
        this.roomName = roomName;
    }
}
