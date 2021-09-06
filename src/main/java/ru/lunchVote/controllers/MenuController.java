package ru.lunchVote.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import ru.lunchVote.models.Menu;
import ru.lunchVote.service.MenuService;

// Sweets
@Tag(name = "Menu", description = "Menu API, Can only be used by admins")
@RestController
@RequestMapping("/cafe/{cafeId}/menu")
public class MenuController {

    private MenuService menuService;

    public MenuController(MenuService menuService){
        this.menuService = menuService;
    }

    @Operation(summary = "Get menu for id")
    @GetMapping("")
    public Menu getMenu(@PathVariable int cafeId){
        return menuService.getMenu(cafeId);
    }

    @Operation(summary = "Create Menu for Cafe", description = "Request and response in JSON")
    @PostMapping("")
    public Menu createMenu(@PathVariable("cafeId") int cafeId, @RequestBody Menu menu){
        return menuService.createAndSaveMenu(cafeId, menu);
    }

    @Operation(summary = "Update Menu for Cafe", description = "Request and response in JSON")
    @PatchMapping("")
    public void updateMenu(@PathVariable("cafeId") int cafeId, @RequestBody Menu menu){
        menuService.createAndSaveMenu(cafeId, menu);
    }
}
