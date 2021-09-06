package ru.lunchVote.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.lunchVote.models.Cafe;
import ru.lunchVote.models.User;
import ru.lunchVote.models.Vote;
import ru.lunchVote.repository.CafeRepository;
import ru.lunchVote.repository.UserRepository;
import ru.lunchVote.repository.VoteRepository;
import ru.lunchVote.util.TimeUtil;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// Sweets
@Service
@Transactional(readOnly = true)
public class CafeService {

    private CafeRepository cafeRepository;
    private VoteRepository voteRepository;
    private UserRepository userRepository;

    public CafeService(CafeRepository cafeRepository, VoteRepository voteRepository, UserRepository userRepository){
        this.cafeRepository = cafeRepository;
        this.voteRepository = voteRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public Cafe create(Cafe cafe) {
        return cafeRepository.save(cafe);
    }

    public Cafe get(int cafeId) {
        return cafeRepository.findById(cafeId).get();
    }

    @Transactional
    public List<Cafe> getAll() {
        List<Cafe> list = new ArrayList<>();
        cafeRepository.findAll().forEach(list::add);
        return list;
    }

    @Transactional
    public void updateMenu(Cafe cafe) {
        cafeRepository.save(cafe);
    }

    @Transactional
    public void delete(int cafeId) {
        cafeRepository.delete(get(cafeId));
    }

    @Transactional
    public Vote vote(int cafeId, String login) {
        LocalDateTime localDateTime = LocalDateTime.now();

        User user = null;
        user = userRepository.findByLogin(login);
        if(user == null){
            return null;
        }
        Cafe cafe = null;
        cafe = cafeRepository.getById(cafeId);
        if(cafe == null){
            return null;
        }

        Vote vote = voteRepository.findByUserIdAndTimeVote(user.getId(), LocalDate.now());
        if(vote == null){
            vote = new Vote();
        }

        if(TimeUtil.checkTime(localDateTime)) {
            vote.setCafeID(cafe.getId());
            vote.setUserId(user.getId());
            vote.setTimeVote(LocalDate.now());
            return voteRepository.save(vote);
        } else {
            return null;
        }
    }

    public Map<Cafe, Integer> getResults() {
        LocalDate localDate = LocalDate.now();
        List<Vote> result = voteRepository.getAllByTimeVote(localDate);
        Map<Cafe, Integer> resultMap = result.stream()
                .collect(
                        Collectors.toMap(vote -> get(vote.getCafeID()), vote -> 1, Integer::sum)
                );
        return resultMap;
    }
}
