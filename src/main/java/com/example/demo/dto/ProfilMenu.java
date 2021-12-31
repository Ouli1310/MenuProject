package com.example.demo.dto;

import com.example.demo.model.Profil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfilMenu {
    private String libelle;
    private String nom;
    private Long priorite;
    private Long parent_id;

    public ProfilMenu(String libelle, String nom) {
        this.libelle = libelle;
        this.nom = nom;
    }
}
