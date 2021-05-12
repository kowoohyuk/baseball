package baseball.service;

import baseball.domain.Team;
import baseball.repository.TeamRepository;
import org.springframework.stereotype.Service;

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

    public Team findTeamById(Long teamId) {
        return teamRepository.findById(teamId).orElseThrow(NullPointerException::new);
    }

    public Team findTeamByPlayerId(Long playerId) {
        Long teamId = teamRepository.findTeamIdByPlayerId(playerId);
        return findTeamById(teamId);
    }
}
