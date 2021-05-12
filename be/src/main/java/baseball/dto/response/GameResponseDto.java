package baseball.dto.response;

import baseball.domain.GameTeamScore;

public class GameResponseDto {
    private int round;
    private boolean turn;
    private TeamResponseDto home;
    private TeamResponseDto away;

    private GameResponseDto() {
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

    public void setHome(TeamResponseDto home) {
        this.home = home;
    }

    public void setAway(TeamResponseDto away) {
        this.away = away;
    }

    public static GameResponseDto of(TeamResponseDto home, TeamResponseDto away) {
        GameTeamScore homeGameTeamScore = home.getGameTeamScore();
        GameTeamScore awayGameTeamScore = away.getGameTeamScore();
        int lastRound = homeGameTeamScore.largerRound(awayGameTeamScore);
        return new GameResponseDto(lastRound, awayGameTeamScore.isTurn(lastRound), home, away);
    }
}
