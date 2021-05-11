package baseball.dto.request;

import baseball.domain.Player;
import baseball.dto.PlayerDto;

import java.util.List;

public class TeamRequestDto {

    private Long id;
    private String name;

    private List<Player> players;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Player> getPlayers() {
        return players;
    }
}
