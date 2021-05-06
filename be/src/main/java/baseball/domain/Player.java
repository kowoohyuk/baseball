package baseball.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

public class Player {

    @Id

    private Long id;
    private String name;
    private String role;

    @Column(value = "player_status")
    private boolean status;

    private Player() {
    }

    public Player(Long id, String name, String role, boolean status) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.status = status;
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

