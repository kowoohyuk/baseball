package baseball.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

public class Player {

    @Id
    private Long id;
    private String name;
    private String role;

    @Column(value = "plate_status")
    private boolean status;

    private Player() {
    }

    public Player(Long id, String name) {
        this.id = id;
        this.name = name;
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

}
