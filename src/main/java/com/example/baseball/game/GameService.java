package com.example.baseball.game;

import com.example.baseball.game.domain.Baseball;
import com.example.baseball.game.domain.Number;
import com.example.baseball.game.domain.Numbers;
import com.example.baseball.game.domain.Score;
import com.example.baseball.game.dto.BaseballDto;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@AllArgsConstructor
public class GameService {

    private final BaseballRepository baseballRepository;

    public Numbers generateNumbers() {
        List<Number> numbers = new ArrayList<>();

        List<Integer> randomNumbers = getRandomNumbers();
        for (int i = 0; i < randomNumbers.size(); i++) {
            numbers.add(Number.of(randomNumbers.get(i), i));
        }
        return Numbers.of(numbers);
    }

    private List<Integer> getRandomNumbers() {
        List<Integer> collect = IntStream.rangeClosed(Number.MIN_NUMBER, Number.MAX_NUMBER)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(collect);
        return collect.subList(0, Numbers.NUMBERS_LENGTH);
    }

    public BaseballDto compare(BaseballDto baseballDto, String predictedValue) {
        Baseball baseball = baseballDto.getBaseball();
        baseball.increaseTryCount();

        Numbers numbers = baseballDto.getNumbers();
        Score score = numbers.compare(predictedValue);
        if (score.isStrike()) {
            baseball.success();
            baseballRepository.save(baseball);
        }
        baseballDto.setScore(score);

        return baseballDto;
    }

    public List<Baseball> getScores() {
        return baseballRepository.findAll(Sort.by(Sort.Direction.ASC, "tryCount"));
    }

}
