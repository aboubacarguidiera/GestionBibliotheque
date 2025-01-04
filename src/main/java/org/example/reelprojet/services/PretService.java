package org.example.reelprojet.services;

import org.example.reelprojet.entities.Pret;
import org.example.reelprojet.repositories.PretRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PretService {
  private PretRepository pretRepository;
  @Autowired
  public PretService(PretRepository pretRepository) {
    this.pretRepository = pretRepository;
  }
  public List<Pret> getAllPrets() {
    return this.pretRepository.findAll();
  }
  public Pret savePret(Pret pret) {
    pret.getAdherent().add(pret);
    return this.pretRepository.save(pret);
  }
}
