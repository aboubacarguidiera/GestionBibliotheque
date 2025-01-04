package org.example.reelprojet.controllers;

import org.example.reelprojet.entities.Adherent;
import org.example.reelprojet.entities.Livre;
import org.example.reelprojet.entities.Pret;
import org.example.reelprojet.repositories.AdherentRepository;
import org.example.reelprojet.repositories.LivreRepository;
import org.example.reelprojet.repositories.PretRepository;
import org.example.reelprojet.services.Catalogue;
import org.example.reelprojet.services.PretService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prets")
public class PretController {
  private PretRepository pretRepository;
  private LivreRepository livreRepository;
  private AdherentRepository adherentRepository;
  @Autowired
  public PretController(PretRepository pretRepository, AdherentRepository adherentRepository, LivreRepository livreRepository) {
    this.pretRepository = pretRepository;
    this.adherentRepository = adherentRepository;
    this.livreRepository = livreRepository;
  }
  @GetMapping("/all")
  public List<Pret> getAllPrets() {
    return this.pretRepository.findAll();
  }
  @PostMapping("/")
  public ResponseEntity<Pret> createPret(@RequestBody Pret pret) {
    // Vérifier et sauvegarder le livre si nécessaire
    Livre livre = livreRepository.findById(pret.getLivre().getNumero()).orElse(null);
    if (livre == null) {
      livre = livreRepository.save(pret.getLivre());
    }

    // Vérifier et sauvegarder l'adherent si nécessaire
    Adherent adherent = adherentRepository.findById(pret.getAdherent().getNumero()).orElse(null);
    if (adherent == null) {
      adherent = adherentRepository.save(pret.getAdherent());
    }

    // Associer les entités sauvegardées au pret
    pret.setLivre(livre);
    pret.setAdherent(adherent);

    // Sauvegarder le pret
    Pret savedPret = pretRepository.save(pret);
    return ResponseEntity.ok(savedPret);
  }
}
