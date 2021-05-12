package baseball.dto.response;

public class FirstGameResponseDto {

    TeamResponseDto home;
    TeamResponseDto away;

    private FirstGameResponseDto(TeamResponseDto home, TeamResponseDto away){
        this.home = home;
        this.away = away;
    }

    public TeamResponseDto getHome() {
        return home;
    }

    public TeamResponseDto getAway() {
        return away;
    }

    public static FirstGameResponseDto of(TeamResponseDto home, TeamResponseDto away){
        return new FirstGameResponseDto(home,away);
    }
}
