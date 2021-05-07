package baseball.controller;

import baseball.GameService;
import baseball.TeamService;
import baseball.domain.Game;
import baseball.domain.GameTeamScore;
import baseball.domain.Player;
import baseball.dto.GameListDto;
import baseball.dto.response.GameResponseDto;
import baseball.dto.response.PlayerResponseDto;
import baseball.dto.response.TeamResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {

    private GameService gameService;
    private TeamService teamService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public ResponseEntity<GameListDto> createGame() {
        GameListDto gameListDto = GameListDto.of(gameService.createGameDtoList());
        return ResponseEntity.ok().body(gameListDto);
    }
}
