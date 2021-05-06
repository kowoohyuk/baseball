package baseball.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Team {

    @Id
    private Long id;
    private String name;

    @MappedCollection(idColumn = "team_id", keyColumn = "id")
    private Set<Player> players = new HashSet<>();

    private Team(){
    }

    public Team(String name, Set<Player> players) {
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

    public Set<Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }
}
