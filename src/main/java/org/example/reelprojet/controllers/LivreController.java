package org.example.reelprojet.controllers;

import org.example.reelprojet.entities.Livre;
import org.example.reelprojet.repositories.LivreRepository;
import org.example.reelprojet.services.Catalogue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/livres")
public class LivreController {
  private Catalogue catalogue ;
   private  LivreRepository livreRepository;
  @Autowired
  public  LivreController(Catalogue catalogue, LivreRepository livreRepository){
    this.catalogue = catalogue;
    this.livreRepository = livreRepository;

  }

  @GetMapping("/all")
  public List<Livre> getAllLivre(){
    return this.catalogue.findAll();
  }
  @PostMapping("/")
  public Livre addLivre(@RequestBody Livre livre){
    return this.livreRepository.save(livre);
  }
  @DeleteMapping("/{id}")
  public void deleteLivre(@PathVariable int id){
    Livre livre = this.livreRepository.findById(id).get();
    this.livreRepository.delete(livre);
  }
  @PutMapping("/{id}")
  public Livre updateLivre(@PathVariable int id, @RequestBody Livre livre){
    return  this.catalogue.updateLivre(id,livre);
  }
 @PatchMapping("/{id}")
  public Livre upadatePartially(@PathVariable int id, @RequestBody Map<String,Object> updates){
    return this.catalogue.updatePartiallyLivre(id,updates);
 }
}
