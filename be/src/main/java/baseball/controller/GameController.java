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

    @GetMapping("/{gameId}")
    public ResponseEntity<GameResponseDto> roadGame(@PathVariable Long gameId){
        Game game = gameService.findGameById(gameId);
        Long homeTeamId = game.getHome();
        Long awayTeamId = game.getAway();
        List<Player> homeTeam = teamService.playersById(homeTeamId);
        List<PlayerResponseDto> playerResponseDtoList = new ArrayList<>();
        GameTeamScore homeTeamGameScore= gameService.GameTeamScoreByIdAndTeamId(gameId,homeTeamId);
        GameTeamScore awayTeamGameScore = gameService.GameTeamScoreByIdAndTeamId(gameId,awayTeamId);
        int round = homeTeamGameScore.getRound();
        boolean turn = gameService.readTurn(gameId);
        Long pitcherId =0L;
        for(Player player : homeTeam) {
            if(player.getRole().equals("투수")){
                pitcherId = player.getId();
            }
            PlayerResponseDto playerResponseDto=PlayerResponseDto.of(player,teamService.GamePlayerDetailByPlayerId(player));
            playerResponseDtoList.add(playerResponseDto);
        }
        TeamResponseDto homeTeamResponseDto = new TeamResponseDto(pitcherId,homeTeamGameScore.getScore(),playerResponseDtoList);

        List<Player> awayTeam = teamService.playerById(awayTeamId);

        return ResponseEntity.ok().body(new GameResponseDto(round,turn,homeTeamResponseDto,awayTeamResponseDto));
    }

}
