package domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.Map;

public class Team {

    @Id
    private Long id;
    private String name;

    @MappedCollection(idColumn = "team_id")
    private Map<Long, Player> players;

    public Team() {
    }

    public Team(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Map<Long, Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player player) {
        players.put(player.getId(), player);
    }

    public Player getPlayerByPlayerId(Long playerId) {
        return players.get(playerId);
    }
}
