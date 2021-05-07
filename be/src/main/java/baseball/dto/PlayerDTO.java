package baseball.dto;

import baseball.domain.Player;

public class PlayerDTO {
    private String name;
    private String role;
    private boolean status;

    public PlayerDTO(String name, String role, boolean status) {
        this.name = name;
        this.role = role;
        this.status = status;
    }

    public Player toPlayer() {
        return new Player(name, role, status);
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
}
