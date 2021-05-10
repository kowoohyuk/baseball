package baseball.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.util.HashSet;
import java.util.Set;

public class Team {

    @Id
    private Long id;
    private String name;

    @Column(value = "team_id")
    private Set<Player> players = new HashSet<>();

    @Column(value = "team_id")
    private Set<GameTeamScore> scores = new HashSet<>();

    private Team() {
    }

    public Team(String name, Set<Player> players) {
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

    public Set<Player> getPlayers() {
        return players;
    }
}
