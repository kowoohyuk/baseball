package baseball.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Game {

    @Id
    private Long id;

    @Column(value = "home_team_id")
    private Long home;

    @Column(value = "away_team_id")
    private Long away;

    @Column(value = "game_id")
    private Set<GameTeamScore> scores = new HashSet<>();

    @MappedCollection(idColumn = "game_id" , keyColumn = "id")
    private List<GamePlayerDetail> playerDetails = new ArrayList<>();

    @Column(value = "play_status")
    private boolean playStatus;

    private Game(Long home, Long away) {
        this.home = home;
        this.away = away;
    }

    public void addPlayerDetail(GamePlayerDetail gamePlayerDetail) {
        playerDetails.add(gamePlayerDetail);
    }

    public void addScores(GameTeamScore gameTeamScore) {
        scores.add(gameTeamScore);
    }

    public Long getId() {
        return id;
    }

    public Long getHome() {
        return home;
    }

    public Long getAway() {
        return away;
    }

    public Set<GameTeamScore> getScores() {
        return scores;
    }

    public List<GamePlayerDetail> getPlayerDetails() {
        return playerDetails;
    }

    public boolean getPlayStatus() {
        return playStatus;
    }

    public static Game of(Team home, Team away) {
        return new Game(home.getId(), away.getId());
    }
}
