package baseball.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.HashSet;
import java.util.Set;

public class Game {
    @Id
    private Long id;

    @MappedCollection(idColumn = "game_id", keyColumn = "id")
    private Set<GameTeamScore> scores = new HashSet<>();

    @MappedCollection(idColumn = "game_id", keyColumn = "id")
    private Set<GamePlayerDetail> playerDetails = new HashSet<>();

    public void addPlayerDetail(GamePlayerDetail gamePlayerDetail) {
        playerDetails.add(gamePlayerDetail);
    }

    public void addScores(GameTeamScore gameTeamScore) {
        scores.add(gameTeamScore);
    }

    public Long getId() {
        return id;
    }

    public Set<GameTeamScore> getScores() {
        return scores;
    }

    public Set<GamePlayerDetail> getPlayerDetails() {
        return playerDetails;
    }
}
