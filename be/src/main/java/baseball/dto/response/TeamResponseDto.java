package baseball.dto.response;

import baseball.domain.GameTeamScore;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Set;

public class TeamResponseDto {

    @JsonProperty("member_list")
    private List<PlayerResponseDto> playerList;
    private int score;
    private Long pitcher;

    public TeamResponseDto(Long pitcher, int score,  List<PlayerResponseDto> playerList){
        this.pitcher = pitcher;
        this.score = score;
        this.playerList = playerList;
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
