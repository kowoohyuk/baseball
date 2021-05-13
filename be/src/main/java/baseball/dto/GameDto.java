package baseball.dto;

import baseball.domain.Game;
import baseball.domain.Team;

public class GameDto {

    private Long id;
    private String home;
    private String away;

    public GameDto(Long id, String home, String away) {
        this.id = id;
        this.home = home;
        this.away = away;
    }

    public Long getId() {
        return id;
    }

    public String getHome() {
        return home;
    }

    public String getAway() {
        return away;
    }

    public static GameDto of(Game game, Team home, Team away) {
        return new GameDto(game.getId(), home.getName(), away.getName());
    }
}
