package org.example.reelprojet.services;

import org.example.reelprojet.entities.Livre;
import org.example.reelprojet.repositories.LivreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
@Service
public class Catalogue {
  LivreRepository livreRepository;
  public Catalogue(LivreRepository livreRepository) {
    this.livreRepository = livreRepository;
  }
public <List> Livre chercherLivre(String isbn) {
    return this.livreRepository.findByIsbn(isbn);
  }
  //public <Livre>
  public Livre updateLivre(int id, Livre livre){
    Optional<Livre> livre1 = this.livreRepository.findById(id);
    if (livre1.isPresent()){
      livre1.get().setAuteur(livre.getAuteur());
      livre1.get().setTitre(livre.getTitre());
      livre1.get().setIsbn(livre.getIsbn());
    }
    return this.livreRepository.save(livre1.get());
}
public List<Livre> findAll(){
    return livreRepository.findAll();
}

public Livre updatePartiallyLivre(int id, Map<String,Object> updates){
    Livre livre = this.livreRepository.findById(id).get();
    if(updates.containsKey("titre")){
      livre.setTitre((String)updates.get("titre"));
    }
    if(updates.containsKey("isbn")){
      livre.setIsbn((String)updates.get("isbn"));
    }
    if(updates.containsKey("auteur")){
      livre.setAuteur((String) updates.get("auteur"));
    }
    return this.livreRepository.save(livre);

}

}
