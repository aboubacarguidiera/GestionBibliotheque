package org.example.reelprojet.entities;

import jakarta.persistence.*;

import java.util.*;
import java.util.stream.Stream;
@Entity
public class Adherent {
  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  private Long numero;
  private String nom;
  private String prenom;
  //@OneToOne(mappedBy = "adherent")

  @OneToMany(mappedBy ="adherent")
  private List<Pret> prets = new ArrayList<>();
  public Adherent() {
  }
  public Adherent(String nom, String prenom) {
    this.nom = nom;
    this.prenom = prenom;
  }


  public Stream<Pret> stream() {
    return prets.stream();
  }

  public int size() {
    return prets.size();
  }

  public boolean isEmpty() {
    return prets.isEmpty();
  }

  public boolean contains(Object o) {
    return prets.contains(o);
  }

  public Iterator<Pret> iterator() {
    return prets.iterator();
  }

  public Object[] toArray() {
    return prets.toArray();
  }

  public boolean add(Pret pret) {
    return prets.add(pret);
  }

  public boolean remove(Object o) {
    return prets.remove(o);
  }

  public boolean containsAll(Collection<?> c) {
    return prets.containsAll(c);
  }

  public void sort(Comparator<? super Pret> c) {
    prets.sort(c);
  }

  public void clear() {
    prets.clear();
  }

  @Override
  public boolean equals(Object o) {
    return prets.equals(o);
  }

  @Override
  public int hashCode() {
    return prets.hashCode();
  }

  public Pret get(int index) {
    return prets.get(index);
  }

  public void add(int index, Pret element) {
    prets.add(index, element);
  }

  public Pret remove(int index) {
    return prets.remove(index);
  }

  public Long getNumero() {
    return numero;
  }

  public void setNumero(Long numero) {
    this.numero = numero;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getPrenom() {
    return prenom;
  }

  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }

  @Override
  public String toString() {
    return "Adherent{" +
      "numero=" + numero +
      ", nom='" + nom + '\'' +
      ", prenom='" + prenom + '\'' +
      '}';
  }
}
