package com.example.jdbcdayone.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@NoArgsConstructor
@Getter
@Setter
public class Part {
    @Id
    private Integer id;
    private String name;
    private Integer quantity;

    public Part(int quantity, String name) {
        this.quantity = quantity;
        this.name = name;
    }

    public Part(Integer id, String name, Integer quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }
}
