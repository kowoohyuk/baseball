package baseball.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlayerRequestDto {

    @JsonProperty(value = "game_id")
    private Long gameId;

    @JsonProperty(value = "at_bat")
    private boolean atBat;

    public PlayerRequestDto(Long gameId, boolean atBat) {
        this.gameId = gameId;
        this.atBat = atBat;
    }

    public Long getGameId() {
        return gameId;
    }

    public boolean getAtBat() {
        return atBat;
    }
}
