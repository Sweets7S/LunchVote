package ru.lunchVote.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.lunchVote.models.Cafe;

@Repository
public interface CafeRepository extends JpaRepository<Cafe, Integer> {
}
