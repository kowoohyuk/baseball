package baseball.dto.response;

import baseball.domain.GamePlayerDetail;
import baseball.domain.Player;

public class PlayerResponseDto {
    private Long id;
    private String name;
    private boolean status;
    private int atBat; //안타
    private int outCount; //아웃
    private int plate_appearance; //타석

    private PlayerResponseDto(Long id, String name, boolean status, int atBat, int outCount, int plate_appearance) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.atBat = atBat;
        this.outCount = outCount;
        this.plate_appearance = plate_appearance;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isStatus() {
        return status;
    }

    public int getAtBat() {
        return atBat;
    }

    public int getOutCount() {
        return outCount;
    }

    public int getPlate_appearance() {
        return plate_appearance;
    }

    public static PlayerResponseDto of(Player player, GamePlayerDetail gamePlayerDetail) {
        return new PlayerResponseDto(player.getId(), player.getName(), player.isStatus(),
                gamePlayerDetail.getAtBat(), gamePlayerDetail.getOutCount(), gamePlayerDetail.getPlateAppearance());
    }
}
