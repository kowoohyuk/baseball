package baseball.dto.request;

public class GamePlayerDetailRequestDto {

    private int atBat;
    private int outCount;
    private int plateAppearance;

    public GamePlayerDetailRequestDto() {
    }

    public GamePlayerDetailRequestDto(int atBat, int outCount, int plateAppearance) {
        this.atBat = atBat;
        this.outCount = outCount;
        this.plateAppearance = plateAppearance;
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
