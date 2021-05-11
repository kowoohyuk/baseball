package baseball;

import baseball.domain.Game;
import baseball.domain.GamePlayerDetail;
import baseball.domain.Player;
import baseball.domain.Team;
import baseball.dto.response.PlayerResponseDto;
import baseball.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamService {

    private TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<Team> findTeams() {
        return teamRepository.findAll();
    }

    public List<Player> playersById(Long TeamId) {
        Team team = teamRepository.findById(TeamId).orElseThrow(NullPointerException::new);
        return team.getPlayers();
    }

    public GamePlayerDetail gamePlayerDetailByPlayerId(Long playerId) {
        return teamRepository.gamePlayerDetailByPlayerId(playerId).orElseThrow(NullPointerException::new);
    }

    public List<PlayerResponseDto> createPlayerResponseDtoList(boolean playStatus, List<Player> team) {
        List<PlayerResponseDto> playerResponseDtoList = new ArrayList<>();
        GamePlayerDetail gamePlayerDetail = new GamePlayerDetail();

        for (Player player : team) {
            if (playStatus) {
                gamePlayerDetail = gamePlayerDetailByPlayerId(player.getId());
            }
            PlayerResponseDto playerResponseDto = PlayerResponseDto.of(player, gamePlayerDetail);
            playerResponseDtoList.add(playerResponseDto);
        }
        return playerResponseDtoList;
    }

    public Player findPitcherByTeamId(Long teamId) {
        return teamRepository.findPitcherById(teamId).orElseThrow(NullPointerException::new);
    }

    public Team findTeamById(Long teamId) {
        return teamRepository.findTeamById(teamId).orElseThrow(NullPointerException::new);
    }

    public void changePlayerStatus(boolean playStatus, Game game) {
        if (!playStatus) {
            Long homeTeamId = game.getHome();
            Long awayTeamId = game.getAway();

            Team homeTeam = findTeamById(homeTeamId);
            Team awayTeam = findTeamById(awayTeamId);

            Player homeFirstPlayer = homeTeam.findFirstPlayer();
            Player awayPitcher = awayTeam.findPlayer(findPitcherByTeamId(awayTeamId));

            homeFirstPlayer.isPlay();
            awayPitcher.isPlay();

            teamRepository.save(homeTeam);
            teamRepository.save(awayTeam);
        }
    }
}
