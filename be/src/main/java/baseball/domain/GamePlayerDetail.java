package baseball.domain;

import baseball.dto.request.GamePlayerDetailRequestDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

public class GamePlayerDetail {

    @Id
    private Long id;
    private int atBat;
    private int outCount;
    private int plateAppearance;

    @Column(value = "player_id")
    private Long playerId;

    public GamePlayerDetail() {
    }

    public GamePlayerDetail( int atBat, int outCount, int plateAppearance) {
        this.atBat = atBat;
        this.outCount = outCount;
        this.plateAppearance = plateAppearance;
    }

    public void updatePlayerDetail(GamePlayerDetailRequestDto gamePlayerDetailRequestDto) {
        this.atBat = gamePlayerDetailRequestDto.getAtBat();
        this.outCount = gamePlayerDetailRequestDto.getOutCount();
        this.plateAppearance = gamePlayerDetailRequestDto.getPlateAppearance();
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

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }
}
