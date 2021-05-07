package baseball.domain;

public class GameTeamScore {

    private Long id;
    private int score;
    private int round;

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
}
