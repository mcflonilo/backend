package com.example.eksamenprep;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter @NoArgsConstructor @Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq_gen")
    @SequenceGenerator(name="customer_seq_gen", sequenceName="customer_seq", allocationSize = 1)
    @Column(name = "CustomerId")
    private Long customerId = 0L;

    @Column(name = "CustomerName")
    private String customerName;

    @Column(name = "CustomerEmail")
    private String customerEmail;

    @OneToMany(cascade = CascadeType.ALL)
    @JsonIgnoreProperties("customer")
    @JoinColumn(name = "CustomerId")
    private List<Pet> pets = new ArrayList<>();



    public Customer(String customerName, String customerEmail) {
        this.customerName = customerName;
        this.customerEmail = customerEmail;
    }
}
