package baseball.controller;

import baseball.domain.Player;
import baseball.dto.request.TeamRequestDto;
import baseball.domain.Team;
import baseball.repository.TeamRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerController {

    private TeamRepository teamRepository;

    public PlayerController(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @PostMapping("/players")
    public ResponseEntity createPlayerList(@RequestBody TeamRequestDto teamRequestDTO) {
        Team team = teamRepository.findById(teamRequestDTO.getId()).get();
        for (Player player : teamRequestDTO.getPlayers()) {
            team.addPlayer(player);
        }
        teamRepository.save(team);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
