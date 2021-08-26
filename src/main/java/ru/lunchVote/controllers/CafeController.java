package ru.lunchVote.controllers;

import org.springframework.web.bind.annotation.*;
import ru.lunchVote.models.Cafe;
import ru.lunchVote.service.CafeService;

import java.util.List;

// Sweets
@RestController
@RequestMapping("/cafe")
public class CafeController {

    private CafeService cafeService;

    public CafeController(CafeService cafeService){
        this.cafeService = cafeService;
    }

    @PostMapping("")
    public Cafe create(@RequestBody Cafe cafe){
        System.out.println(cafe);
        return cafeService.create(cafe);
    }

    @GetMapping("/{cafeId}")
    public Cafe get(@PathVariable("cafeId") int cafeId){
        return cafeService.get(cafeId);
    }

    @GetMapping("")
    public List<Cafe> getAll(){
        return cafeService.getAll();
    }

    @PatchMapping("")
    public void updateMenu(@RequestBody Cafe cafe){
        if (true) { //todo затычка на админа
            cafeService.updateMenu(cafe);
        }
    }

    @DeleteMapping("/{cafeId}")
    public void delete(@PathVariable("cafeId") int cafeId){
        cafeService.delete(cafeId);
    }

    @PatchMapping("/{cafeId}")
    public void voteCafe(@PathVariable int cafeId){
        cafeService.vote(cafeId);
    }
}
