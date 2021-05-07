package baseball.domain;

import baseball.dto.GamePlayerDetaileDTO;

public class GamePlayerDetail {

    private Long id;
    private int atBat = 0;
    private int outCount = 0;
    private int plateAppearance = 0;

    public GamePlayerDetail() {
    }

    public void updatePlayerDetail(GamePlayerDetaileDTO gamePlayerDetaileDto) {
        this.atBat = gamePlayerDetaileDto.getAtBat();
        this.outCount = gamePlayerDetaileDto.getOutCount();
        this.plateAppearance = gamePlayerDetaileDto.getPlateAppearance();
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
