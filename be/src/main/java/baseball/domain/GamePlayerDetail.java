package baseball.domain;

import org.springframework.data.relational.core.mapping.Column;

public class GamePlayerDetail {

    private int atBat;
    private int outCount;
    private int plateAppearance;

    @Column(value = "player_id")
    private Long playerId;

    @Column(value = "game_id")
    private Long gameId;

    public GamePlayerDetail() {
    }

    public GamePlayerDetail(int atBat, int outCount, int plateAppearance) {
        this.atBat = atBat;
        this.outCount = outCount;
        this.plateAppearance = plateAppearance;
    }

    public void updatePlayerDetail(GamePlayerDetail gamePlayerDetail) {
        this.atBat = gamePlayerDetail.getAtBat();
        this.outCount = gamePlayerDetail.getOutCount();
        this.plateAppearance = gamePlayerDetail.getPlateAppearance();
    }

    public int getAtBat() {
        return atBat;
    }

    public int getOutCount() {
        return outCount;
    }

    public int getPlateAppearance() {
        return plateAppearance;
    }

    public Long getPlayerId() {
        return playerId;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public void update(boolean isAtBat) {
        plateAppearance++;
        if (isAtBat) {
            atBat++;
            return;
        }
        outCount++;
    }
}
