package ru.lunchVote.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.lunchVote.models.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {
}
