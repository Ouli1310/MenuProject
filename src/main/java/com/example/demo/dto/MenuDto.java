package com.example.demo.dto;


import com.example.demo.model.Menu;
import com.example.demo.model.Profil;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Id;
import java.util.Set;

@Data
public class MenuDto {

    @Id
    private Long id;
    private String libelle;
    private String code;
    private String icon;
    private String route;
    private Long parentId;
    private Long priorite;
    private Long profilId;
}
