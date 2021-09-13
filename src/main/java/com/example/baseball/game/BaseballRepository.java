package com.example.baseball.game;

import com.example.baseball.game.domain.Baseball;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseballRepository extends JpaRepository<Baseball, Long> {
}
