package baseball.domain;

import baseball.dto.PlayerDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Player {

    @Id
    private Long id;
    private String name;
    private String role;

    @Column(value = "player_status")
    private boolean status;

    @Column(value = "player_id")
    private Set<GamePlayerDetail> playerDetails = new HashSet<>();

    public Player() {
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

    public void isPlay(){
        status = true;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return status == player.status && id.equals(player.id) && name.equals(player.name) && role.equals(player.role) && playerDetails.equals(player.playerDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, role, status, playerDetails);
    }
}

