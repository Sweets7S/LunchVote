package ru.lunchVote.service;

import org.springframework.stereotype.Service;
import ru.lunchVote.models.Cafe;
import ru.lunchVote.models.Vote;
import ru.lunchVote.repository.CafeRepository;
import ru.lunchVote.repository.VoteRepository;
import ru.lunchVote.util.TimeUtil;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

// Sweets
@Service
public class CafeService {

    private CafeRepository cafeRepository;
    private VoteRepository voteRepository;

    public CafeService(CafeRepository cafeRepository, VoteRepository voteRepository){
        this.cafeRepository = cafeRepository;
        this.voteRepository = voteRepository;
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


    public void vote(int cafeId) {
        Vote vote = new Vote();
        if(TimeUtil.checkTime(LocalDateTime.of(2020, 8, 26, 10, 55, 45))) {
            vote.setCafeID(cafeId);
            vote.setTimeVote(LocalDateTime.of(2020, 8, 26, 10, 55, 45));
            vote.setId(100000);
            voteRepository.save(vote);
        } else {
            System.out.println("Позже 11");
            //todo Доделать метод голосования
        }
    }
}
