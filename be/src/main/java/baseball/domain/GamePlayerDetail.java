package baseball.domain;

import baseball.dto.request.GamePlayerDetailRequestDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

public class GamePlayerDetail {

    @Id
    private Long id;
    @Column(value = "game_id")
    private Long gameId;
    private int atBat = 0;
    private int outCount = 0;
    private int plateAppearance = 0;

    public GamePlayerDetail() {
    }

    public void updatePlayerDetail(GamePlayerDetailRequestDto gamePlayerDetailRequestDto) {
        this.atBat = gamePlayerDetailRequestDto.getAtBat();
        this.outCount = gamePlayerDetailRequestDto.getOutCount();
        this.plateAppearance = gamePlayerDetailRequestDto.getPlateAppearance();
    }

    public Long getId() {
        return id;
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
}
