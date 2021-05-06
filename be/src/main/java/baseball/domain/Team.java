package baseball.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.HashMap;
import java.util.Map;

public class Team {

    @Id
    private Long id;
    private String name;

    @MappedCollection(idColumn = "team_id", keyColumn = "id")
    private Map<Long, Player> players = new HashMap<>();

    private Team(){
    }

    public Team(String name, Map<Long, Player> players) {
        this.name = name;
        this.players = players;
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
