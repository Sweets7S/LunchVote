package ru.lunchVote.service;

import org.springframework.stereotype.Service;
import ru.lunchVote.models.Cafe;
import ru.lunchVote.repository.CafeRepository;

import java.util.ArrayList;
import java.util.List;

// Sweets
@Service
public class CafeService {

    private CafeRepository cafeRepository;

    public CafeService(CafeRepository cafeRepository){
        this.cafeRepository = cafeRepository;
    }

    public Cafe create(Cafe cafe) {
        return cafeRepository.save(cafe);
    }

    public Cafe get(int cafeId) {
        return cafeRepository.findById(cafeId).get();
    }

    public List<Cafe> getAll() {
        List<Cafe> list = new ArrayList<>();
        cafeRepository.findAll().forEach(list::add);
        return list;
    }

    public void updateMenu(Cafe cafe) {
        cafeRepository.save(cafe);
    }

    public void delete(int cafeId) {
        cafeRepository.delete(get(cafeId));
    }
}
