package com.example.demo.serviceImpl;

import com.example.demo.dto.MenuDto;
import com.example.demo.dto.ProfilDto;
import com.example.demo.model.Menu;
import com.example.demo.model.Profil;
import com.example.demo.repository.ProfilRepository;
import com.example.demo.service.ProfilService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProfilServiceImpl implements ProfilService {

    private final ModelMapper modelMapper;
    private final ProfilRepository profilRepository;

    private Profil convertToEntity(ProfilDto profilDto) {
        Profil profil = new Profil();
        profil = modelMapper.map(profilDto, Profil.class);
        return profil;
    }

    @Override
    public Profil createProfil(ProfilDto profilDto) {
        Profil profil = new Profil();
        profil = convertToEntity(profilDto);
        try {
            return profilRepository.save(profil);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Profil> getListProfil() {
        return profilRepository.findAll();
    }

    @Override
    public Profil getProfilById(Long id) {
        return profilRepository.findById(id).orElse(null);
    }
}
