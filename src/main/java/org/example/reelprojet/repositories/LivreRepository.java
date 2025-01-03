package org.example.reelprojet.repositories;

import org.example.reelprojet.entities.Livre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface LivreRepository extends JpaRepository<Livre, Integer> {
  public Livre findByIsbn(String isbn);

  //public Livre findByTitreAndByAuteur(String titre, String auteur);
  public Livre findByAuteurAndTitre(String titre, String author);

  @Query("Select l from Livre as l where l.titre like %:theme%")
  public List<Livre> findByTheme(String theme);
}

