package baseball.controller;

import baseball.GameService;
import baseball.TeamService;
import baseball.domain.Game;
import baseball.domain.GameTeamScore;
import baseball.dto.GameListDto;
import baseball.dto.response.GameResponseDto;
import baseball.dto.response.PlayerResponseDto;
import baseball.dto.response.TeamResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/games")
public class GameController {

    private GameService gameService;
    private TeamService teamService;


    public GameController(GameService gameService, TeamService teamService) {
        this.gameService = gameService;
    }

    @GetMapping
    public ResponseEntity<GameListDto> createGame() {
        GameListDto gameListDto = GameListDto.of(gameService.createGameDtoList());
        return ResponseEntity.ok().body(gameListDto);
    }

    @GetMapping("/{gameId}")
    public ResponseEntity<GameResponseDto> roadGame(@PathVariable Long gameId) {
        Game game = gameService.findGameById(gameId);
        if (game.getPlayStatus()) {
            TeamResponseDto homeTeamResponseDto = createTeamResponseDto(game.getHome());
            TeamResponseDto awayTeamResponseDto = createTeamResponseDto(game.getAway());
            return ResponseEntity.ok().body(GameResponseDto.of(homeTeamResponseDto, awayTeamResponseDto));
        }

        TeamResponseDto homeTeamResponseDto = createTeamResponseDto(gameId, game.getHome());
        TeamResponseDto awayTeamResponseDto = createTeamResponseDto(gameId, game.getAway());
        return ResponseEntity.ok().body(GameResponseDto.of(homeTeamResponseDto, awayTeamResponseDto));
    }

    private TeamResponseDto createTeamResponseDto(Long gameId, Long teamId) {
        GameTeamScore gameTeamScore = gameService.LastGameTeamScoreByIdAndTeamId(gameId, teamId);
        Long pitcherId = teamService.findPitcherIdByTeamId(teamId);
        Set<PlayerResponseDto> playerResponseDtoSet = teamService.createPlayerResponseDtoSet(teamService.playersById(teamId));
        return TeamResponseDto.of(pitcherId, playerResponseDtoSet, gameTeamScore);
    }

}
