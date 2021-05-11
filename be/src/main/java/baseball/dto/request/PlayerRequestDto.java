package baseball.dto.request;

public class PlayerRequestDto {

    private Long gameId;
    private boolean atBat;

    public Long getGameId() {
        return gameId;
    }

    public boolean isAtBat() {
        return atBat;
    }
}
