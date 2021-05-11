package baseball.dto.response;

import baseball.domain.GameTeamScore;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Set;

public class TeamResponseDto {

    @JsonProperty("member_list")
    private Set<PlayerResponseDto> playerList;
    private int score;
    private Long pitcherId;

    @JsonIgnore
    private GameTeamScore gameTeamScore;

    public TeamResponseDto(Long pitcherId, int score, Set<PlayerResponseDto> playerSet, GameTeamScore gameTeamScore) {
        this.pitcherId = pitcherId;
        this.score = score;
        this.playerList = playerSet;
        this.gameTeamScore = gameTeamScore;
    }

    public GameTeamScore getGameTeamScore() {
        return gameTeamScore;
    }

    public Set<PlayerResponseDto> getPlayerList() {
        return playerList;
    }

    public int getScore() {
        return score;
    }

    public Long getPitcherId() {
        return pitcherId;
    }

    public static TeamResponseDto of(Long pitcherId, Set<PlayerResponseDto> playerSet, GameTeamScore gameTeamScore) {
        return new TeamResponseDto(pitcherId, gameTeamScore.getScore(), playerSet, gameTeamScore);
    }

}
