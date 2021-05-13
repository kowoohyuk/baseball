package baseball.repository;

import baseball.domain.GamePlayerDetail;
import baseball.domain.Player;
import baseball.domain.Team;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TeamRepository extends CrudRepository<Team, Long> {

    List<Team> findAll();

    @Query("SELECT team.id , team.name FROM team WHERE team.id = :teamId")
    Optional<Team> findTeamById(Long teamId);

    @Query("SELECT player.id, player.name, player.role, player.team_id, player.player_status FROM player " +
            "INNER JOIN team ON player.team_id = team.id " +
            "WHERE player.team_id = :teamId AND player.role = '투수'")
    Optional<Player> findPitcherById(Long teamId);

    @Query("SELECT player.team_id FROM player " +
            "INNER JOIN team ON player.team_id = team.id " +
            "WHERE player.id = :playerId")
    Long findTeamIdByPlayerId(Long playerId);

    Optional<GamePlayerDetail> findGamePlayerDetailByPlayerIdAndGameId(Long playerId, Long gameId);
}
