package baseball.controller;

import baseball.domain.Team;
import baseball.dto.request.PlayerRequestDto;
import baseball.service.GameService;
import baseball.service.PlayerService;
import baseball.service.TeamService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/players")
public class PlayerController {

    private GameService gameService;
    private TeamService teamService;
    private PlayerService playerService;

    public PlayerController(GameService gameService, TeamService teamService, PlayerService playerService) {
        this.gameService = gameService;
        this.teamService = teamService;
        this.playerService = playerService;
    }

    @PutMapping("/{playerId}")
    public ResponseEntity updatePlayer(@PathVariable Long playerId, @RequestBody PlayerRequestDto playerRequestDto) {
        Team team = teamService.findTeamByPlayerId(playerId);
        gameService.updateGamePlayerDetail(playerId, playerRequestDto.getGameId(), team, playerRequestDto.getAtBat());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
