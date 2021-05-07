package baseball.dto;

public class GamePlayerDetaileDTO {

    private int atBat;
    private int outCount;
    private int plateAppearance;

    public GamePlayerDetaileDTO() {
    }

    public GamePlayerDetaileDTO(int atBat, int outCount, int plateAppearance) {
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
