package baseball.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Team {

    @Id
    private Long id;
    private String name;

    @MappedCollection(idColumn = "team_id", keyColumn = "id")
    private List<Player> players = new ArrayList<>();

    @Column(value = "team_id")
    private Set<GameTeamScore> scores = new HashSet<>();

    private Team() {
    }

    public Team(String name, List<Player> players) {
        this.name = name;
        this.players = players;
    }

    public Team(String name) {
        this.name = name;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void addScores(GameTeamScore gameTeamScore) {
        scores.add(gameTeamScore);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Player findPlayer(Long playerId) {
        return players.stream().filter(player -> player.getId().equals(playerId)).findFirst()
                .orElseThrow(NullPointerException::new);
    }

    public Player findFirstPlayer() {
        return players.get(0);
    }

    public Player findLastPlayer() {
        return players.get(players.size()-1);
    }
}
