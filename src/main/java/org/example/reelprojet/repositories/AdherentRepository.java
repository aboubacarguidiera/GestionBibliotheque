package org.example.reelprojet.repositories;

import org.example.reelprojet.entities.Adherent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdherentRepository extends JpaRepository<Adherent, Integer> {
}
