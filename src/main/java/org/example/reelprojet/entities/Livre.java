package org.example.reelprojet.entities;

import jakarta.persistence.*;

import java.util.Objects;
@Entity
public class Livre {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer numero;
  private String titre;
  private String auteur;
  @Column(unique=false, nullable = false)
  private String isbn;

  public Livre(String titre, String auteur, String isbn) {
    this.titre = titre;
    this.auteur = auteur;
    this.isbn = isbn;
  }

  public Livre() {

  }

  public Integer getNumero() {
    return numero;
  }

  public String getTitre() {
    return titre;
  }

  public void setTitre(String titre) {
    this.titre = titre;
  }

  public String getAuteur() {
    return auteur;
  }

  public void setAuteur(String auteur) {
    this.auteur = auteur;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  @Override
  public String toString() {
    return "Livre{" +
      "titre='" + titre + '\'' +
      ", auteur='" + auteur + '\'' +
      ", isbn='" + isbn + '\'' +
      '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Livre livre = (Livre) o;
    return Objects.equals(titre, livre.titre) && Objects.equals(auteur, livre.auteur) && Objects.equals(isbn, livre.isbn);
  }

  @Override
  public int hashCode() {
    return Objects.hash(titre, auteur, isbn);
  }
}
