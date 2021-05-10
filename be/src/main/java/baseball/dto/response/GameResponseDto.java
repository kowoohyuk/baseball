package baseball.dto.response;

import java.util.List;

public class GameResponseDto {
    private int round;
    private boolean turn;
    private TeamResponseDto home;
    private TeamResponseDto away;

    public GameResponseDto() {
    }

    public GameResponseDto(int round, boolean turn, TeamResponseDto home, TeamResponseDto away) {
        this.round = round;
        this.turn = turn;
        this.home = home;
        this.away = away;
    }

    public int getRound() {
        return round;
    }

    public boolean isTurn() {
        return turn;
    }

    public TeamResponseDto getHome() {
        return home;
    }

    public TeamResponseDto getAway() {
        return away;
    }
}
