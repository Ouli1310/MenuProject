package com.example.demo.dto;


import com.example.demo.model.Menu;
import lombok.Data;

import javax.persistence.Id;
import java.util.List;

@Data
public class ProfilDto {

    @Id
    private Long id;
    private String nom;
    private String code;
    private String domaine;
    private List<Menu> menus;
}
