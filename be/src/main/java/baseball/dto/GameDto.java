package baseball.dto;

import baseball.domain.Game;

public class GameDto {

    private Long id;
    private Long home;
    private Long away;

    private GameDto(Long id, Long home, Long away) {
        this.id = id;
        this.home = home;
        this.away = away;
    }

    public Long getId() {
        return id;
    }

    public Long getHome() {
        return home;
    }

    public Long getAway() {
        return away;
    }

    public static GameDto of(Game game) {
        return new GameDto(game.getId(), game.getHome(), game.getAway());
    }
}
