package baseball.service;

import baseball.domain.Player;
import baseball.domain.Team;
import baseball.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    private TeamRepository teamRepository;

    public PlayerService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<Player> playersById(Long TeamId) {
        Team team = teamRepository.findTeamById(TeamId).orElseThrow(NullPointerException::new);
        return team.getPlayers();
    }

    public Player findPitcherByTeamId(Long teamId) {
        return teamRepository.findPitcherById(teamId).orElseThrow(NullPointerException::new);
    }

    public void changePlayerStatus(boolean playStatus, Team home, Team away) {
        if (!playStatus) {

            Player homeFirstPlayer = home.findFirstPlayer();
            Player awayPitcher = away.findPlayer(findPitcherByTeamId(away.getId()).getId());

            homeFirstPlayer.isPlay();
            awayPitcher.isPlay();

            teamRepository.save(home);
            teamRepository.save(away);
        }
    }

}
