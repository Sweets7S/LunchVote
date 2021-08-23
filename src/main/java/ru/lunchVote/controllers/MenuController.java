package ru.lunchVote.controllers;

import org.springframework.web.bind.annotation.*;
import ru.lunchVote.models.Menu;
import ru.lunchVote.service.MenuService;

// Sweets
@RestController
@RequestMapping("/cafe/{cafeId}/menu")
public class MenuController {

    private MenuService menuService;

    public MenuController(MenuService menuService){
        this.menuService = menuService;
    }

    @GetMapping("")
    public Menu getMenu(@PathVariable int cafeId){
        return menuService.getMenu(cafeId);
    }

    @PostMapping("")
    public Menu createAndSaveMenu(@PathVariable("cafeId") int cafeId, @RequestBody Menu menu){
        return menuService.createAndSaveMenu(cafeId, menu);
    }

    @PatchMapping("")
    public void updateMenu(@PathVariable("cafeId") int cafeId, @RequestBody Menu menu){
        menuService.createAndSaveMenu(cafeId, menu);
    }
}
