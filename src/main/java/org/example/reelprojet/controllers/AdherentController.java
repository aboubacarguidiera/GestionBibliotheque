
package org.example.reelprojet.controllers;

import org.example.reelprojet.entities.Adherent;
import org.example.reelprojet.repositories.AdherentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/adherents")
public class AdherentController {
  private AdherentRepository adherentRepository;
  public AdherentController(AdherentRepository adherentRepository) {
    this.adherentRepository = adherentRepository;
  }
  @GetMapping("/all")
  @ResponseBody()
  public List<Adherent> adherents() {
    return this.adherentRepository.findAll();
  }
  @GetMapping("/{id}")
  public Adherent adherent(@PathVariable int id) {
    return this.adherentRepository.findById(id).orElse(null);
  }
  @PostMapping("/add")
  @ResponseBody()

  public Adherent addAdherent(@RequestBody Adherent adherent) {
    return this.adherentRepository.save(adherent);
  }
  @PostMapping("/multiple")
  @ResponseBody
  public List<Adherent> addMultiple(@RequestBody List<Adherent> adherents) {

    return this.adherentRepository.saveAll(adherents);
  }
  @DeleteMapping("/{id}")
  @ResponseBody
  public Adherent deleteAdherent(@PathVariable int id) {
    this.adherentRepository.deleteById(id);
    return this.adherentRepository.findById(id).orElse(null);
  }
}
