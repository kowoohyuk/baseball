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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/games")
public class GameController {

    private GameService gameService;
    private TeamService teamService;


    public GameController(GameService gameService, TeamService teamService) {
        this.gameService = gameService;
        this.teamService = teamService;
    }

    @GetMapping
    public ResponseEntity<GameListDto> createGame() {
        GameListDto gameListDto = GameListDto.of(gameService.createGameDtoList(teamService.findTeams()));
        return ResponseEntity.ok().body(gameListDto);
    }

    @GetMapping("/{gameId}")
    public ResponseEntity<GameResponseDto> roadGame(@PathVariable Long gameId) {
        Game game = gameService.findGameById(gameId);
        TeamResponseDto homeTeamResponseDto = createTeamResponseDto(gameId, game.getHome());
        TeamResponseDto awayTeamResponseDto = createTeamResponseDto(gameId, game.getAway());
        return ResponseEntity.ok().body(GameResponseDto.of(homeTeamResponseDto, awayTeamResponseDto));
    }

    private TeamResponseDto createTeamResponseDto(Long gameId, Long teamId) {
        boolean playStatus = gameService.findPlayStatusById(gameId);
        GameTeamScore gameTeamScore = gameService.LastGameTeamScoreByIdAndTeamId(playStatus, gameId, teamId);
        Long pitcherId = teamService.findPitcherIdByTeamId(teamId);
        Set<PlayerResponseDto> playerResponseDtoSet = teamService.createPlayerResponseDtoSet(playStatus, teamService.playersById(teamId));
        return TeamResponseDto.of(pitcherId, playerResponseDtoSet, gameTeamScore);
    }
}
