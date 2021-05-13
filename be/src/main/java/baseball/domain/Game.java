package baseball.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.util.HashSet;
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

    @Column(value = "game_id")
    private Set<GamePlayerDetail> playerDetails = new HashSet<>();

    @Column(value = "last_batting_player")
    private Long lastBattingPlayer;

    @Column(value = "play_status")
    private boolean playStatus;

    private Game(Long home, Long away) {
        this.home = home;
        this.away = away;
    }

    public void addPlayerDetail(GamePlayerDetail gamePlayerDetail) {
        playerDetails.add(gamePlayerDetail);
    }

    public GamePlayerDetail findGamePlayerDetail(Long playerId) {
        return playerDetails.stream()
                .filter(gamePlayerDetail -> gamePlayerDetail.getPlayerId().equals(playerId))
                .findFirst()
                .orElseThrow(NullPointerException::new);
    }

    public GameTeamScore findGameTeamScore(int round, Long teamId) {
        return scores.stream()
                .filter(gameScore -> gameScore.getRound() == round && gameScore.getTeamId() == teamId)
                .findFirst()
                .orElseThrow(NullPointerException::new);
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

    public Long getLastBattingPlayer() {
        return lastBattingPlayer;
    }

    public void setLastBattingPlayer(Long lastBattingPlayer) {
        this.lastBattingPlayer = lastBattingPlayer;
    }

    public Set<GameTeamScore> getScores() {
        return scores;
    }

    public Set<GamePlayerDetail> getPlayerDetails() {
        return playerDetails;
    }

    public boolean getPlayStatus() {
        return playStatus;
    }

    public void isPlay() {
        playStatus = true;
    }

    public static Game of(Team home, Team away) {
        return new Game(home.getId(), away.getId());
    }

}
