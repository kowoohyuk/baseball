package baseball.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GameTeamScoreDto {

    @JsonProperty(value = "game_id")
    private Long gameId;

    @JsonProperty(value = "home")
    private int homeScore;

    @JsonProperty(value = "away")
    private int awayScore;

    private int round;


    public GameTeamScoreDto(Long gameId, int homeScore, int awayScore, int round) {
        this.gameId = gameId;
        this.homeScore = homeScore;
        this.awayScore = awayScore;
        this.round = round;
    }

    public Long getGameId() {
        return gameId;
    }

    public int getTeamScore() {
        return homeScore;
    }

    public int getAwayScore() {
        return awayScore;
    }

    public int getRound() {
        return round;
    }
}
