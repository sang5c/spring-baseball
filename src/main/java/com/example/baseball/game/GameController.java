package com.example.baseball.game;

import com.example.baseball.game.domain.Baseball;
import com.example.baseball.game.domain.Numbers;
import com.example.baseball.game.domain.Score;
import com.example.baseball.game.dto.BaseballDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@AllArgsConstructor
@Slf4j
public class GameController {

    private final GameService gameService;

    @GetMapping("/game")
    public String game(@RequestParam String username, HttpSession httpSession) {
        log.debug(username + "game start");
        Numbers numbers = gameService.generateNumbers();
        Baseball baseball = new Baseball();
        baseball.setUsername(username);
        BaseballDto baseballDto = new BaseballDto(baseball, numbers);
        httpSession.setAttribute("info", baseballDto);
        return "baseball";
    }

    @ResponseBody
    @GetMapping("/go")
    public Score predict(@RequestParam String value, HttpSession httpSession) {
        log.debug(httpSession.getAttribute("info") + "");
        BaseballDto baseballDto = (BaseballDto) httpSession.getAttribute("info");
        BaseballDto resultDto = gameService.compare(baseballDto, value);
        httpSession.setAttribute("info", resultDto);
        return resultDto.getScore();
    }

    @GetMapping("/score")
    public String scoreBoard(Model model) {
        List<Baseball> baseballs = gameService.getScores();
        model.addAttribute("tt", baseballs);
        model.addAttribute("kk", "value");
        return "score";
    }
}
