package baseball.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GameTeamScoreDto {

    @JsonProperty(value = "game_id")
    private Long gameId;

    @JsonProperty(value = "home")
    private Integer homeScore;

    @JsonProperty(value = "away")
    private Integer awayScore;

    private int round;


    public GameTeamScoreDto(Long gameId, Integer homeScore, Integer awayScore, int round) {
        this.gameId = gameId;
        this.homeScore = homeScore;
        this.awayScore = awayScore;
        this.round = round;
    }

    public Long getGameId() {
        return gameId;
    }

    public Integer getTeamScore() {
        return homeScore;
    }

    public Integer getAwayScore() {
        return awayScore;
    }

    public int getRound() {
        return round;
    }
}
