package com.example.demo.repository;
import com.example.demo.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
public interface MenuRepository extends JpaRepository<Menu, Long> {

    @Query(nativeQuery = true, value = "SELECT *   FROM tp_menu_item  where profil_id= :profilId ORDER BY priorite ASC ")
    List<Menu> getMenuByProfil(@Param("profilId") Long id);

    List<Menu> findMenuByOrderByPrioriteAsc();

    List<Menu> findMenuByParentIdOrderByPrioriteAsc(Long Id);


}
