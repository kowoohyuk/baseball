package baseball.dto.response;

import baseball.domain.GameTeamScore;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class TeamResponseDto {

    private Long teamId;
    @JsonProperty("member_list")
    private List<PlayerResponseDto> playerList;
    private int score;
    private Long pitcherId;
    private String name;

    @JsonIgnore
    private GameTeamScore gameTeamScore;

    public TeamResponseDto(Long pitcherId, Long teamId, String name, int score, List<PlayerResponseDto> playerList, GameTeamScore gameTeamScore) {
        this.pitcherId = pitcherId;
        this.teamId = teamId;
        this.name = name;
        this.score = score;
        this.playerList = playerList;
        this.gameTeamScore = gameTeamScore;
    }

    public GameTeamScore getGameTeamScore() {
        return gameTeamScore;
    }

    public List<PlayerResponseDto> getPlayerList() {
        return playerList;
    }

    public int getScore() {
        return score;
    }

    public Long getPitcherId() {
        return pitcherId;
    }

    public String getName() {
        return name;
    }

    public Long getTeamId() {
        return teamId;
    }
}
