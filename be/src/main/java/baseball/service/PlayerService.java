package baseball.service;

import baseball.domain.Game;
import baseball.domain.Player;
import baseball.domain.Team;
import baseball.dto.request.ChangeGameTeamScoreDto;
import baseball.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    private TeamRepository teamRepository;

    public PlayerService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public Team findTeamById(Long teamId) {
        return teamRepository.findTeamById(teamId).orElseThrow(NullPointerException::new);
    }

    public List<Player> playersById(Long teamId) {
        Team team = findTeamById(teamId);
        return team.getPlayers();
    }

    public Player findPitcherByTeamId(Long teamId) {
        return teamRepository.findPitcherById(teamId).orElseThrow(NullPointerException::new);
    }

    public void firstGamePlayerStatus(Team home, Team away) {
        Player homeFirstPlayer = home.findFirstPlayer();
        Player awayPitcher = away.findPlayer(findPitcherByTeamId(away.getId()).getId());

        home.changeStatusFalse();
        away.changeStatusFalse();
        homeFirstPlayer.isPlay();
        awayPitcher.isPlay();

        teamRepository.save(home);
        teamRepository.save(away);
    }

    public void remarkPlayerStatus(Team team, Long playerId) {
        Player lastPlayer = team.findLastPlayer();
        Player finishBattingPlayer = team.findPlayer(playerId);
        finishBattingPlayer.isNotPlay();
        if (lastPlayer.equals(finishBattingPlayer)) {
            Player firstPlayer = team.findFirstPlayer();
            firstPlayer.isPlay();
            teamRepository.save(team);
            return;
        }
        Player nextPlayer = team.findPlayer(playerId + 1);
        nextPlayer.isPlay();
        teamRepository.save(team);
    }

    public void changePlayerStatus(Game game, ChangeGameTeamScoreDto changeGameTeamScoreDto) {
        Long attackTeamId = game.getHome();
        Long defenseTeamId = game.getAway();
        Long lastAttackTeamId = changeGameTeamScoreDto.getTeamId();
        Long previousLastBattingPlayerId = game.getLastBattingPlayer();

        if (lastAttackTeamId.equals(attackTeamId)) {
            attackTeamId = defenseTeamId;
            defenseTeamId = lastAttackTeamId;
        }

        Team attackTeam = findTeamById(attackTeamId);
        Team defenseTeam = findTeamById(defenseTeamId);
        Player startBatter = defenseTeam.findFirstPlayer();


        if (!attackTeam.findPlayer(previousLastBattingPlayerId).equals(attackTeam.findLastPlayer())) {
            startBatter = attackTeam.findPlayer(previousLastBattingPlayerId + 1);
        }

        Player lastStatusTruePlayer = defenseTeam.findStatusTruePlayer();
        Player previousPitcher = attackTeam.findPlayer(findPitcherByTeamId(attackTeamId).getId());
        Player pitcher = defenseTeam.findPlayer(findPitcherByTeamId(defenseTeamId).getId());

        pitcher.isPlay();
        startBatter.isPlay();
        lastStatusTruePlayer.isNotPlay();
        previousPitcher.isNotPlay();

        teamRepository.save(attackTeam);
        teamRepository.save(defenseTeam);
    }

    public void firstChangePlayerStatus(Game game) {
        Team home = findTeamById(game.getHome());
        Team away = findTeamById(game.getAway());

        Player homePitcher = home.findPlayer(findPitcherByTeamId(home.getId()).getId());
        Player awayFirstPlayer = away.findFirstPlayer();
        Player awayPitcher = away.findPlayer(findPitcherByTeamId(away.getId()).getId());

        home.changeStatusFalse();
        homePitcher.isPlay();
        awayPitcher.isNotPlay();
        awayFirstPlayer.isPlay();

        teamRepository.save(home);
        teamRepository.save(away);
    }
}
