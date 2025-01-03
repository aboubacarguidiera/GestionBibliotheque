package org.example.reelprojet.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Pret {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long numero;
  @OneToOne
 private Livre livre;
  private LocalDate date;

  @JoinColumn(name = "adherent")// adherent au lieu de  adherent_numero
  @ManyToOne
  private Adherent adherent;


  @Override
  public String toString() {
    return "Pret{" +
      "numero=" + numero +
      ", livre=" + livre +
      ", date=" + date +
      ", adherent=" + adherent +
      '}';
  }



  public Pret() {
  }

  public Pret(Livre livre, LocalDate date, Adherent adherent) {
    this.livre = livre;
    this.date = date;
    this.adherent = adherent;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public Long getNumero() {
    return numero;
  }


  public Livre getLivre() {
    return livre;
  }

  public void setLivre(Livre livre) {
    this.livre = livre;
  }

  public Adherent getAdherent() {
    return adherent;
  }

  public void setAdherent(Adherent adherent) {
    this.adherent = adherent;
  }
}


