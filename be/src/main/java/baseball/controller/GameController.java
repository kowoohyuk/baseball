package baseball.controller;

import baseball.GameService;
import baseball.dto.GameListDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/games")
public class GameController {

    private GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public ResponseEntity<GameListDto> createGame() {
        GameListDto gameListDto = GameListDto.of(gameService.createGameDtoList());
        return ResponseEntity.ok().body(gameListDto);
    }
}
