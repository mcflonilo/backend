package com.example.eksamenprep.Repo;

import com.example.eksamenprep.Model.Vet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VetRepo extends JpaRepository<Vet, Long> {
}
