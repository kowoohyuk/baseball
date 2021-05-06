package baseball.controller;

import baseball.domain.Player;
import baseball.domain.Team;
import baseball.dto.PlayerDto;
import baseball.repository.TeamRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlayerController {

    private TeamRepository teamRepository;

    public PlayerController(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @PostMapping("/players")
    public ResponseEntity createPlayerList(@RequestBody PlayerDto playerDto) {
        Team team = teamRepository.findById(playerDto.getTeamId()).get();
        List<Player> players = playerDto.getPlayers();
        for (Player player : players) {
            team.addPlayer(player);
        }
        teamRepository.save(team);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
