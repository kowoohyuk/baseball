package baseball.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ChangeGameTeamScoreDto {

    @JsonProperty(value = "game_id")
    private Long gameId;

    @JsonProperty(value = "team_id")
    private Long teamId;

    @JsonProperty(value = "player_id")
    private Long playerId;

    private int round;

    public ChangeGameTeamScoreDto(Long gameId, Long teamId, Long playerId, int round) {
        this.gameId = gameId;
        this.teamId = teamId;
        this.playerId = playerId;
        this.round = round;
    }

    public Long getGameId() {
        return gameId;
    }

    public Long getTeamId() {
        return teamId;
    }

    public Long getPlayerId() {
        return playerId;
    }

    public int getRound() {
        return round;
    }
}

