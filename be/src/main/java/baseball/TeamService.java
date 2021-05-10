package baseball;

import baseball.domain.GamePlayerDetail;
import baseball.domain.Player;
import baseball.domain.Team;
import baseball.dto.response.PlayerResponseDto;
import baseball.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TeamService {

    private TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<Team> findTeams() {
        return teamRepository.findAll();
    }

    public Set<Player> playersById(Long TeamId) {
        Team team = teamRepository.findById(TeamId).orElseThrow(NullPointerException::new);
        return team.getPlayers();
    }

    public GamePlayerDetail gamePlayerDetailByPlayerId(Long playerId) {
        return teamRepository.gamePlayerDetailByPlayerId(playerId).orElseThrow(NullPointerException::new);
    }

    public Set<PlayerResponseDto> createPlayerResponseDtoSet(Set<Player> team) {
        Set<PlayerResponseDto> playerResponseDtoSet = new HashSet<>();
        for (Player player : team) {
            PlayerResponseDto playerResponseDto = PlayerResponseDto.of(player, gamePlayerDetailByPlayerId(player.getId()));
            playerResponseDtoSet.add(playerResponseDto);
        }
        return playerResponseDtoSet;
    }

    public Long findPitcherIdByTeamId(Long teamId) {
        return teamRepository.findPitcherIdById(teamId);
    }
}
