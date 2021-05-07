package baseball.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.HashSet;
import java.util.Set;

public class Player {

    @Id

    private Long id;
    private String name;
    private String role;

    @Column(value = "player_status")
    private boolean status;

    @MappedCollection(idColumn = "team_id", keyColumn = "id")
    private Set<GamePlayerDetail> playerDetails = new HashSet<>();

    private Player() {
    }

    public Player(String name, String role, boolean status) {
        this.name = name;
        this.role = role;
        this.status = status;
    }

    public void addPlayer(GamePlayerDetail gamePlayerDetail) {
        playerDetails.add(gamePlayerDetail);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public boolean isStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", status=" + status +
                '}';
    }
}

