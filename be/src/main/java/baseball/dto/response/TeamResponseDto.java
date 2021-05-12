package baseball.dto.response;

import baseball.domain.GameTeamScore;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class TeamResponseDto {

    @JsonProperty("member_list")
    private List<PlayerResponseDto> playerList;
    private int score;
    private Long pitcherId;

    @JsonIgnore
    private GameTeamScore gameTeamScore;

    public TeamResponseDto(Long pitcherId, int score, List<PlayerResponseDto> playerList, GameTeamScore gameTeamScore) {
        this.pitcherId = pitcherId;
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
}
