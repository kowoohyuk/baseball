package baseball.repository;

import baseball.domain.GamePlayerDetail;
import baseball.domain.Team;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TeamRepository extends CrudRepository<Team, Long> {
    List<Team> findAll();

    @Query("SELECT game_player_detail.id, game_player_detail.at_bat, game_player_detail.out_count, game_player_detail.plate_appearance" +
            "FROM game_player_detail join Player ON Player.id = game_player_detail.player_id;")
    Optional<GamePlayerDetail> gamePlayerDetailByPlayerId(Long playerId);

    @Query("SELECT player.id FROM player INNER JOIN ON player.team_id = team.id " +
            "WHERE player.team_id = :teamId AND player.role = '투수' ")
    Long findPitcherIdById(Long teamId);
}
