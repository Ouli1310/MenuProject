package com.example.demo.serviceImpl;

import com.example.demo.dto.MenuDto;
import com.example.demo.model.Menu;
import com.example.demo.repository.MenuRepository;
import com.example.demo.service.MenuService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepository;

    private final ModelMapper modelMapper;

    private MenuDto convertToDto(Menu menu) {
        MenuDto menuDto = new MenuDto();
        menuDto = modelMapper.map(menu, MenuDto.class);
        return menuDto;
    }

    private Menu convertToEntity(MenuDto menuDto) {
        Menu menu = new Menu();
        menu = modelMapper.map(menuDto, Menu.class);
        return menu;
    }

    @Override
    public Menu createMenu(MenuDto menuDto) {
        Menu menu = new Menu();
        menu = convertToEntity(menuDto);
        try {
            menuRepository.save(menu);
        }catch (Exception e) {
            return null;
        }

        return menu;
    }

    @Override
    public Menu updateMenu(Long id, Menu menu) {
        Menu currentMenu = menuRepository.findById(id).orElse(null);
        currentMenu.setId(menu.getId());
        currentMenu.setLibelle(menu.getLibelle());
        currentMenu.setCode(menu.getCode());
        currentMenu.setIcon(menu.getIcon());
        currentMenu.setRoute(menu.getRoute());
        currentMenu.setParentId(menu.getParentId());
        currentMenu.setPriorite(menu.getPriorite());

        Menu updatedMenu = menuRepository.save(currentMenu);
        return updatedMenu;
    }

    @Override
    public List<Menu> getListMenu() {
        return menuRepository.findAll();
    }

    @Override
    public List<Menu> getMenuByProfil(Long id) {
        return menuRepository.getMenuByProfil(id);
    }

    @Override
    public Menu getMenuById(Long id) {
        return menuRepository.findById(id).orElse(null);
    }



    @Override
    public void deleteMenuById(Long id) {
        menuRepository.deleteById(id);
    }

    @Override
    public List<Menu> getMenuOrderByPriorite() {
        return menuRepository.findMenuByOrderByPrioriteAsc();
    }

    @Override
    public List<Menu> getMenuByParentIdOBASC(Long id) {
        return menuRepository.findMenuByParentIdOrderByPrioriteAsc(id);
    }
}
