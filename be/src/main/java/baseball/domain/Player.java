package baseball.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Player {

    @Id
    private Long id;
    private String name;
    private String role;

    @Column(value = "player_status")
    private boolean status;

    @MappedCollection(idColumn = "player_id")
    List<GamePlayerDetail> gamePlayerDetails = new ArrayList<>();

    public Player() {
    }

    public Player(String name, String role, boolean status) {
        this.name = name;
        this.role = role;
        this.status = status;
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

    public void addGamePlayerDetail(GamePlayerDetail gamePlayerDetail){
        this.gamePlayerDetails.add(gamePlayerDetail);
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
        return status == player.status && id.equals(player.id) && name.equals(player.name) && role.equals(player.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, role, status);
    }
}

