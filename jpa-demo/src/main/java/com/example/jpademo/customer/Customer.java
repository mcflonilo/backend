package com.example.jpademo.customer;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "customer")
public class Customer{
    @Id
    @GeneratedValue(generator = "customer_seq_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "customer_seq_gen", sequenceName = "customer_seq", allocationSize = 1)
    private Long customerId;
    private String customerName;
    protected Customer(String customerName){
        this.customerName = customerName;
    }

}
