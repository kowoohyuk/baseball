package baseball.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

public class GameTeamScore {

    @Id
    private Long id;
    private int score = 0;
    private int round = 0;

    @Column(value = "game_id")
    private Long gameId;

    @Column(value = "team_id")
    private Long teamId;

    public GameTeamScore() {
    }

    private GameTeamScore(int score, int round) {
        this.score = score;
        this.round = round;
    }

    public Long getId() {
        return id;
    }

    public int getScore() {
        return score;
    }

    public int getRound() {
        return round;
    }

    public Long getTeamId() {
        return teamId;
    }

    public int largerRound(GameTeamScore otherTeam) {
        int otherTeamRound = otherTeam.getRound();
        return Math.max(round, otherTeamRound);
    }

    public void updateScore(int score) {
        this.score = score;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public boolean isTurn(int round) {
        return round != this.round;
    }

    public static GameTeamScore of(int round) {
        return new GameTeamScore(0, round);
    }
}
