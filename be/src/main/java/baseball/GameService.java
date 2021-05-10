package baseball;

import baseball.domain.Game;

import baseball.domain.GameTeamScore;
import baseball.domain.Team;
import baseball.dto.GameDto;
import baseball.repository.GameRepository;
import baseball.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class GameService {

    private GameRepository gameRepository;
    private TeamRepository teamRepository;

    public GameService(GameRepository gameRepository, TeamRepository teamRepository) {
        this.gameRepository = gameRepository;
        this.teamRepository = teamRepository;
    }

    public List<GameDto> createGameDtoList() {
        List<Team> teamList = teamRepository.findAll();
        List<GameDto> gameDtoList = new ArrayList<>();

        Collections.shuffle(teamList);

        for(int i =0; i < teamList.size()-1; i+=2) {
            Game game = Game.of(teamList.get(i), teamList.get(i+1));
            gameRepository.save(game);
            gameDtoList.add(GameDto.of(game));
        }

        return gameDtoList;
    }

    public Game findGameById(Long gameId) {
    }

    public GameTeamScore GameTeamScoreByIdAndTeamId(Long gameId, Long homeTeamId) {
    }

    public boolean readTurn(Long gameId) {
    }
}
