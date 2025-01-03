package org.example.reelprojet;

import org.example.reelprojet.entities.Adherent;
import org.example.reelprojet.entities.Livre;
import org.example.reelprojet.entities.Pret;
import org.example.reelprojet.repositories.AdherentRepository;
import org.example.reelprojet.repositories.LivreRepository;
import org.example.reelprojet.repositories.PretRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Optional;

@SpringBootApplication
public class ReelProjetApplication {
  @Autowired
  LivreRepository livreRepository;
  @Autowired
  AdherentRepository adherentRepository;
  @Autowired
  PretRepository pretRepository;


  public static void main(String[] args) {
    SpringApplication.run(ReelProjetApplication.class, args);
  }

//  @Bean
//  public CommandLineRunner coucou() {
//    return args -> {
//      Livre l1 = new Livre("Misérables", "Victor Hugo", "VV1HH");
//      Livre l2 = new Livre("Atomic Habits", "Abou","aabb");
//      Livre l3 = new Livre ("Quantum Computing", "Bakary","qqcc");
////      Adherent a1 = new Adherent(1231L,"Sylla", "Ali");
////      Adherent a2 = new Adherent(3333L,"Bammou","Moussa");
//      System.out.println("La liste des adherents");
//      adherentRepository.findAll().stream().forEach(System.out::println);
////      // Vérifier et insérer les livres
//      saveLivreIfNotExists(l1);
//      saveLivreIfNotExists(l2);
//      saveLivreIfNotExists(l3);
////
////      Adherent a3 = new Adherent(1111L, "Mohamed", "Cissé");
//      Optional<Adherent> a2 = adherentRepository.findById(1);
//
//      Optional<Adherent> a1 = adherentRepository.findById(2);
//      livreRepository.save(l1);
//      livreRepository.save(l2);
//      livreRepository.save(l3);
//      Pret p1 = new Pret(l1, LocalDate.now(), a1.orElse(null));
//      pretRepository.save(p1);
//
//
////      p1.setDate(LocalDate.now());
//      a1.get().add(p1);
////      a1.add(new Pret(2321L, l2, a1));
////      a1.stream().forEach(System.out::println);
////      System.out.println("afficher par id");
////      livreRepository.findById(1).ifPresent(System.out::println);
////      // System.out.println(livreRepository.findByIsbn("VVHH"));
////      livreRepository.findAll().stream().forEach(System.out::println);
////      System.out.println(l1.toString());
////      System.out.println("Affichage par theme");
////      livreRepository.findByTheme("Misér").stream().forEach(System.out::println);
////      adherentRepository.save(a1);
////      adherentRepository.save(a2);
////      adherentRepository.save(a3);
////    };
////  }
////
////  private void saveLivreIfNotExists(Livre livre) {
////    Livre existingLivre = livreRepository.findByIsbn(livre.getIsbn());
////    if (existingLivre == null) {
////      livreRepository.save(livre);
////    }
////  }
//
//    };
//
//  }
//  private void saveLivreIfNotExists(Livre livre) {
//    Livre existingLivre = livreRepository.findByIsbn(livre.getIsbn());
//    if (existingLivre == null) {
//      livreRepository.save(livre);
//    }
//  }

}


