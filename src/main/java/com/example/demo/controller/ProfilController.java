package com.example.demo.controller;


import com.example.demo.dto.ProfilDto;
import com.example.demo.model.Menu;
import com.example.demo.model.Profil;
import com.example.demo.repository.ProfilRepository;
import com.example.demo.service.ProfilService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "*", maxAge = 3600)
@AllArgsConstructor
public class ProfilController {

    private final ProfilRepository profilRepository;
    private final ProfilService profilService;

    @GetMapping("/profils")
    public List<Profil> getAllProfils() {
        return profilService.getListProfil();
    }

    @PostMapping("/profils")
    public Profil newProfil(@RequestBody ProfilDto profilDto) {
        return profilService.createProfil(profilDto);
    }

    @GetMapping("/profils/{id}")
    public Profil getProfilById(@PathVariable(value = "id") Long id) {
        return profilService.getProfilById(id);
    }

}
