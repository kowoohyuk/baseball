package baseball.domain;

import org.springframework.data.annotation.Id;

public class Player {

    @Id
    private Long id;
    private String name;

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
}
