package baseball.dto.response;

import java.util.List;

public class GameScoreListDto {

    private List<Integer> home;
    private List<Integer> away;

    public GameScoreListDto(List<Integer> home, List<Integer> away) {
        this.home = home;
        this.away = away;
    }

    public List<Integer> getHome() {
        return home;
    }

    public List<Integer> getAway() {
        return away;
    }
}
