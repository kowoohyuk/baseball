package baseball;

import java.util.ArrayList;
import java.util.List;

public class TeamDTO {
    private Long id;
    private String name;

    private List<PlayerDTO> players;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<PlayerDTO> getPlayers() {
        return players;
    }
}
