package baseball.controller;

import baseball.domain.Game;
import baseball.domain.GameTeamScore;
import baseball.domain.Player;
import baseball.dto.GameListDto;
import baseball.dto.request.ChangeGameTeamScoreDto;
import baseball.dto.request.GameTeamScoreDto;
import baseball.dto.response.FirstGameResponseDto;
import baseball.dto.response.GameResponseDto;
import baseball.dto.response.PlayerResponseDto;
import baseball.dto.response.TeamResponseDto;
import baseball.service.GameService;
import baseball.service.PlayerService;
import baseball.service.TeamService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {

    private GameService gameService;
    private TeamService teamService;
    private PlayerService playerService;


    public GameController(GameService gameService, TeamService teamService, PlayerService playerService) {
        this.gameService = gameService;
        this.teamService = teamService;
        this.playerService = playerService;
    }

    @GetMapping
    public ResponseEntity<GameListDto> createGame() {
        GameListDto gameListDto = GameListDto.of(gameService.createGameDtoList(teamService.findTeams()));
        return ResponseEntity.ok().body(gameListDto);
    }

    @GetMapping("/{gameId}")
    public ResponseEntity readGame(@PathVariable Long gameId) {
        Game game = gameService.findGameById(gameId);
        boolean playStatus = gameService.findPlayStatusById(gameId);
        playerService.changePlayerStatus(playStatus, teamService.findTeamById(game.getHome()), teamService.findTeamById(game.getAway()));
        TeamResponseDto homeTeamResponseDto = createTeamResponseDto(playStatus, gameId, game.getHome());
        TeamResponseDto awayTeamResponseDto = createTeamResponseDto(playStatus, gameId, game.getAway());
        /*gameService.isPlay(gameId);*/
        if(playStatus) {
            return ResponseEntity.ok().body(GameResponseDto.of(homeTeamResponseDto, awayTeamResponseDto));
        }
        return ResponseEntity.ok().body(FirstGameResponseDto.of(homeTeamResponseDto, awayTeamResponseDto));
    }

    @PostMapping("/{gameId}")
    public ResponseEntity createGameScore(@PathVariable Long gameId, ChangeGameTeamScoreDto changeGameTeamScoreDto) {
        gameService.createGameHomeTeamScore(changeGameTeamScoreDto);
        return ResponseEntity.ok().body("성공");
    }

    @PutMapping("/{gameId}")
    public ResponseEntity updateScore(@PathVariable Long gameId, @RequestBody GameTeamScoreDto gameTeamScoreDto) {
        gameService.updateGameTeamScore(gameId, gameTeamScoreDto);
        return ResponseEntity.ok().body("성공");
    }

    private TeamResponseDto createTeamResponseDto(boolean playStatus, Long gameId, Long teamId) {
        GameTeamScore gameTeamScore = gameService.LastGameTeamScoreByIdAndTeamId(playStatus, gameId, teamId);
        Player pitcher = playerService.findPitcherByTeamId(teamId);
        List<PlayerResponseDto> playerResponseDtoList = gameService.createPlayerResponseDtoList(gameId, playStatus, playerService.playersById(teamId));
        return TeamResponseDto.of(pitcher.getId(), playerResponseDtoList, gameTeamScore);
    }


}
