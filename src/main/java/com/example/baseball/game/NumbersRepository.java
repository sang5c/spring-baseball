package com.example.baseball.game;

import com.example.baseball.game.domain.Numbers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NumbersRepository extends JpaRepository<Numbers, Long> {
}
