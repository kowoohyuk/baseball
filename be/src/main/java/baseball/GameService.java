package baseball;

import baseball.domain.*;
import baseball.dto.GameDto;
import baseball.dto.response.PlayerResponseDto;
import baseball.repository.GameRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class GameService {

    private GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<GameDto> createGameDtoList(List<Team> teamList) {
        List<GameDto> gameDtoList = new ArrayList<>();
        Collections.shuffle(teamList);

        for (int i = 0; i < teamList.size() - 1; i += 2) {
            Game game = Game.of(teamList.get(i), teamList.get(i + 1));
            gameRepository.save(game);
            gameDtoList.add(GameDto.of(game));
        }
        return gameDtoList;
    }

    public Game findGameById(Long gameId) {
        return gameRepository.findById(gameId).orElseThrow(NullPointerException::new);
    }

    public GameTeamScore LastGameTeamScoreByIdAndTeamId(boolean playStatus, Long gameId, Long teamId) {
        if (playStatus) {
            return gameRepository.findLastGameTeamScoreByIdAndTeamId(gameId, teamId).orElseThrow(NullPointerException::new);
        }
        return new GameTeamScore();
    }

    public boolean findPlayStatusById(Long gameId) {
        return gameRepository.findPlayStatusById(gameId);
    }

    public GamePlayerDetail gamePlayerDetailByPlayerId(Long gameId,Long playerId) {
        return gameRepository.gamePlayerDetailByPlayerId(gameId,playerId).orElseThrow(NullPointerException::new);
    }

    public List<PlayerResponseDto> createPlayerResponseDtoList(Long gameId, boolean playStatus, List<Player> team) {
        Game game = findGameById(gameId);
        List<PlayerResponseDto> playerResponseDtoList = new ArrayList<>();
        GamePlayerDetail gamePlayerDetail = new GamePlayerDetail();

        for (Player player : team){
            Long playerId = player.getId();
            gamePlayerDetail.setPlayerId(playerId);
            if (playStatus) {
                gamePlayerDetail = gamePlayerDetailByPlayerId(gameId, playerId);
            }
            game.addPlayerDetail(gamePlayerDetail);
            gameRepository.save(game);
            PlayerResponseDto playerResponseDto = PlayerResponseDto.of(player, gamePlayerDetail);
            playerResponseDtoList.add(playerResponseDto);
        }

        return playerResponseDtoList;
    }
}
