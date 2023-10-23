package com.example.jdbcdayone.repository;

import com.example.jdbcdayone.model.Part;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartRepository extends ListCrudRepository<Part, Integer> {
}
