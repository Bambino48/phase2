package com.digitalsouaag.salaire.entity;

import jakarta.persistence.*;


import java.time.LocalDateTime;

// Creation de la classe Employer
@SuppressWarnings("ALL")
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
abstract class Employer {
    // Declaration des variables
    @Id
    @GeneratedValue()
    private long id;
    // Les accesseurs et les mutateurs

    private String nom;

    private String prenom;

    private int age;

    private LocalDateTime dateEntrerService;

    // Constructeur par defaut
    public Employer() {
    }

    // Constructeur avec parametre
    public Employer(String nom, String prenom, int age, LocalDateTime dateEntrerService) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.dateEntrerService = dateEntrerService;
    }

    // La methode permettant d'afficher le nom et le prenom de l'employer
    public String afficherNomPrenom() {
        return getNom() + " " + getPrenom();
    }

    // La methode permettant le calcul de salaire
    abstract double calculerSalaire();

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDateTime getDateEntrerService() {
        return dateEntrerService;
    }

    public void setDateEntrerService(LocalDateTime dateEntrerService) {
        this.dateEntrerService = dateEntrerService;
    }

    public Long getId() {
        return id;
    }
}