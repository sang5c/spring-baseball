package com.example.baseball.game;

import com.example.baseball.game.domain.Numbers;
import com.example.baseball.game.domain.Score;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    private final NumbersRepository numbersRepository;

    public GameService(NumbersRepository numbersRepository) {
        this.numbersRepository = numbersRepository;
    }

    public void create() {
        // TODO: 숫자 랜덤 생성, 저장함
        Numbers numbers = Numbers.of("123");
        numbersRepository.save(numbers);
    }

    public Score compare(String username, String numbers) {
        // TODO:
        //  1. repo에서 username과 numbers로 저장된 값을 가져옴.
        //  2. 받은 값과 비교하여 결과 반환
        return Score.of(0, 0);
    }

}
