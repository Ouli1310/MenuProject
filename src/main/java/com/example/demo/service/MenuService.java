package com.example.demo.service;
import com.example.demo.dto.MenuDto;
import com.example.demo.model.Menu;

import java.util.List;

public interface MenuService {

    Menu createMenu(MenuDto menuDto);
    Menu updateMenu(Long id, Menu menu);
    List<Menu> getListMenu();
    List<Menu> getMenuByProfil(Long id);
    Menu getMenuById(Long id);
    void deleteMenuById(Long id);
    List<Menu> getMenuOrderByPriorite();
    List<Menu> getMenuByParentIdOBASC(Long id);
}
