package ru.lunchVote.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.lunchVote.models.Vote;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Integer> {
}
