package com.example.baseball.game;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {

    // TODO: 닉네임을 설정하고 닉네임별 시도횟수가 있으면 좋을듯.
    //  닉네임별로 게임을 각자 돌리는 것도 고려할 것. (구현상의 편의를 위해서..)
    //  몇번만에 맞췄는지 카운트도 있으면 좋을듯.
    @GetMapping("/game")
    public String game() {
        // TODO: 게임을 생성하고 페이지를 반환
        return "";
    }
    
    @GetMapping("/예측하기")
    public String 예측() {
        // TODO: 결과, 카운트 반환
        return "";
    }

}
