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

    @MappedCollection(idColumn = "away_team_id", keyColumn = "id")
    private Set<Game> awayTeamGame = new HashSet<>();

    @MappedCollection(idColumn = "home_team_id", keyColumn = "id")
    private Set<Game> homeTeamGame = new HashSet<>();

    @MappedCollection(idColumn = "team_id", keyColumn = "id")
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

    public void addAwayTeamGame(Game game) {
        awayTeamGame.add(game);
    }

    public void addHomeTeamGame(Game game) {
        homeTeamGame.add(game);
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
