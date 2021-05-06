package baseball.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

public class Player {

    @Id
    private Long id;
    private String name;
    private String role;
    private Long teamId;

    @Column(value = "player_status")
    private boolean status;

    private Player() {
    }

    public Player(String name, String role, Long teamId, boolean status) {
        this.name = name;
        this.role = role;
        this.teamId = teamId;
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

    public Long getTeamId() {
        return teamId;
    }

    public boolean isStatus() {
        return status;
    }
}

