package baseball.domain;

public class GamePlayerDetail {

    private Long id;
    private int atBat;
    private int out;
    private int plateAppearance;

    public GamePlayerDetail() {
    }

    public GamePlayerDetail(int atBat, int out, int plateAppearance) {
        this.atBat = atBat;
        this.out = out;
        this.plateAppearance = plateAppearance;
    }

    public Long getId() {
        return id;
    }

    public int getAtBat() {
        return atBat;
    }

    public int getOut() {
        return out;
    }

    public int getPlateAppearance() {
        return plateAppearance;
    }
}
