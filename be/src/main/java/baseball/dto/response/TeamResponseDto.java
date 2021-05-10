package baseball.dto.response;

import baseball.domain.Team;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

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
}
