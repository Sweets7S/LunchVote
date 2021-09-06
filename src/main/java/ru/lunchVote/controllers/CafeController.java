package ru.lunchVote.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import ru.lunchVote.models.Cafe;
import ru.lunchVote.models.Vote;
import ru.lunchVote.service.CafeService;

import java.util.List;
import java.util.Map;

// Sweets
@Tag(name = "Cafe", description = "Cafe API, Only admin can modify, User only vote")
@RestController
@RequestMapping("/cafe")
public class CafeController {

    private CafeService cafeService;

    public CafeController(CafeService cafeService){
        this.cafeService = cafeService;
    }

    @Operation(summary = "Create Cafe", description = "Request and response in JSON")
    @PostMapping("")
    public Cafe create(@RequestBody Cafe cafe){
        System.out.println(cafe);
        return cafeService.create(cafe);
    }

    @Operation(summary = "Get cafe for id")
    @GetMapping("/{cafeId}")
    public Cafe get(@PathVariable("cafeId") int cafeId){
        return cafeService.get(cafeId);
    }

    @Operation(summary = "Gets All Cafes")
    @GetMapping("")
    public List<Cafe> getAll(){
        return cafeService.getAll();
    }

    @Operation(summary = "Update Cafe" , description = "Request and response in JSON")
    @PatchMapping("")
    public void updateMenu(@RequestBody Cafe cafe){
        cafeService.updateMenu(cafe);
    }

    @Operation(summary = "Delete Cafe")
    @DeleteMapping("/{cafeId}")
    public void delete(@PathVariable("cafeId") int cafeId){
        cafeService.delete(cafeId);
    }

    @Operation(summary = "Vote for the selected cafe", description = "Only a user with the user role can vote")
    @PatchMapping("/vote/{cafeId}")
    public Vote voteCafe(@PathVariable int cafeId){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return cafeService.vote(cafeId, authentication.getName());
    }

    @Operation(summary = "Show voting results for today")
    @GetMapping("/vote")
    public Map<Cafe, Integer> getResult(){
        return cafeService.getResults();
    }
}
