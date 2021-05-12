package baseball.repository;

import baseball.domain.Game;
import baseball.domain.GamePlayerDetail;
import baseball.domain.GameTeamScore;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface GameRepository extends CrudRepository<Game, Long> {

    List<Game> findAll();

    @Query("SELECT game_team_score.score, game_team_score.round, game_team_score.id FROM game_team_score " +
            "INNER JOIN game ON game.id = game_team_score.game_id " +
            "WHERE game_team_score.game_id = :gameId AND game_team_score.team_id = :teamId")
    Optional<GameTeamScore> findLastGameTeamScoreByIdAndTeamId(Long gameId, Long teamId);

    @Query("SELECT game.play_status FROM game WHERE game.id = :gameId")
    boolean findPlayStatusById(Long gameId);

    @Query("SELECT game_player_detail.at_bat, game_player_detail.out_count, game_player_detail.plate_appearance " +
            "FROM game_player_detail join game ON game.id = game_player_detail.game_id " +
            "WHERE game_player_detail.game_id = :gameId AND game_player_detail.player_id = :playerId ")
    Optional<GamePlayerDetail> gamePlayerDetailByPlayerId(Long gameId, Long playerId);

    @Modifying
    @Query("UPDATE game SET game.play_status = true  WHERE game.id = :gameId")
    void isPlay(Long gameId);
}
