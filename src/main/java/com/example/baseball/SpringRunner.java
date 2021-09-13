package com.example.baseball;

import com.example.baseball.game.BaseballRepository;
import com.example.baseball.game.domain.Baseball;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class SpringRunner implements ApplicationRunner {

    private final BaseballRepository baseballRepository;

    @Override
    public void run(ApplicationArguments args) {
        Baseball baseball1 = new Baseball();
        baseball1.setUsername("tester1");
        baseball1.increaseTryCount();
        baseball1.success();
        baseballRepository.save(baseball1);

        Baseball baseball2 = new Baseball();
        baseball2.setUsername("tester2");
        baseball2.increaseTryCount();
        baseball2.increaseTryCount();
        baseball2.increaseTryCount();
        baseball2.success();
        baseballRepository.save(baseball2);
    }

}
