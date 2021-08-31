package ru.lunchVote.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.lunchVote.models.Vote;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Integer> {
    Vote findByUserIdAndTimeVote(int user_id, LocalDate time_vote);
    List<Vote> getAllByTimeVote(LocalDate time_vote);
}
