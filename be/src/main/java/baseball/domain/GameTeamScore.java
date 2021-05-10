package baseball.domain;

import org.springframework.data.annotation.Id;

public class GameTeamScore {

    @Id
    private Long id;
    private int score = 0;
    private int round = 0;

    public GameTeamScore() {
    }

    public GameTeamScore(int score, int round) {
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

    public int largerRound(GameTeamScore otherTeam) {
        int otherTeamRound = otherTeam.getRound();
        return Math.max(score, otherTeamRound);
    }

    public boolean isTurn(int round){
        return round!=this.round;
    }
}
