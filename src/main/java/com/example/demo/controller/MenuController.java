package com.example.demo.controller;


import com.example.demo.dto.MenuDto;
import com.example.demo.model.Menu;
import com.example.demo.service.MenuService;
import com.example.demo.service.ProfilService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "*", maxAge = 3600, allowedHeaders = "*")
@AllArgsConstructor
public class MenuController {
    private final MenuService menuService;
    private final ProfilService profilService;


    @GetMapping("/menus")
    public List<Menu> getAllMenus() {
        return menuService.getListMenu();
    }


    @PostMapping("/menus")
    public Menu newMenu(@RequestBody MenuDto menuDto) {
        return menuService.createMenu(menuDto);
    }

    @PutMapping("/menus/{id}")
    public Menu updateMenu(@PathVariable(value = "id") Long id, @RequestBody Menu menu) {
        Menu updatedMenu = menuService.getMenuById(id);
        updatedMenu.setLibelle(menu.getLibelle());
        updatedMenu.setIcon(menu.getIcon());
        updatedMenu.setCode(menu.getCode());
        updatedMenu.setRoute(menu.getRoute());
        updatedMenu.setParentId(menu.getParentId());
        updatedMenu.setPriorite(menu.getPriorite());
        updatedMenu.setProfilId(menu.getProfilId());
        return menuService.updateMenu(id, updatedMenu);
    }



    @GetMapping("/getInfo/{id}")
    public List<Menu> getInfo(@PathVariable Long id){
            return menuService.getMenuByProfil(id);
        }

        @GetMapping("/menus/{id}")
    public Menu getMenuById(@PathVariable(value = "id") Long id) {
        return menuService.getMenuById(id);
    }

    @GetMapping("getMenuOrderByPriorite")
    public List<Menu> getMenuOrderByPriorite() {
        return menuService.getMenuOrderByPriorite();
    }

    @GetMapping("/getMenuByParentIdOBASC/{id}")
    public List<Menu> getMenuByParentIdOBASC(@PathVariable(value = "id") Long id) {
        return menuService.getMenuByParentIdOBASC(id);
    }

    @DeleteMapping("/menus/{id}")
    public void deleteMenu(@PathVariable(value = "id") Long id) {
        menuService.deleteMenuById(id);
    }
    }
