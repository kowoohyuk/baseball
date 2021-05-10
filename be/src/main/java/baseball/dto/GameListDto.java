package baseball.dto;

import baseball.domain.Game;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class GameListDto {

    @JsonProperty(value = "game_list")
    private List<GameDto> gameDtoList;

    private GameListDto(List<GameDto> gameDtoList) {
        this.gameDtoList = gameDtoList;
    }

    public List<GameDto> getGameDtoList() {
        return gameDtoList;
    }

    public static GameListDto of(List<GameDto> gameDtoList) {
        return new GameListDto(gameDtoList);
    }
}
