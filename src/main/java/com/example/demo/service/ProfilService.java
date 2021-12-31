package com.example.demo.service;

import com.example.demo.model.Profil;
import com.example.demo.dto.ProfilDto;
import com.example.demo.model.Menu;
import com.example.demo.model.Profil;

import java.util.List;

public interface ProfilService {

    Profil createProfil(ProfilDto profilDto);
    List<Profil> getListProfil();
    Profil getProfilById(Long id);
}
