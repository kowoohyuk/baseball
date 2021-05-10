package baseball;

import baseball.domain.Game;
import baseball.domain.GameTeamScore;
import baseball.domain.Team;
import baseball.dto.GameDto;
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

    public GameTeamScore LastGameTeamScoreByIdAndTeamId(Long gameId, Long teamId) {
        return gameRepository.findLastGameTeamScoreByIdAndTeamId(gameId, teamId).orElseThrow();
    }

    public boolean findPlayStatusById(Long gameId) {
        return gameRepository.findPlayStatusById(gameId);
    }
}
