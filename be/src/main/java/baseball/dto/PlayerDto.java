package baseball.dto;

import baseball.domain.Player;

import java.util.List;

public class PlayerDto {
    private Long teamId;
    private List<Player> players;

    private PlayerDto(){
    }

    public PlayerDto(Long teamId, List<Player> players) {
        this.teamId = teamId;
        this.players = players;
    }

    public Long getTeamId() {
        return teamId;
    }

    public List<Player> getPlayers() {
        return players;
    }
}
