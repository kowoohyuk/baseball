package baseball.controller;

import baseball.domain.Player;
import baseball.domain.Team;
import baseball.repository.TeamRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerController {

    private TeamRepository teamRepository;

    public PlayerController(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @PostMapping("/{teamId}/players")
    public ResponseEntity createPlayerList(@PathVariable Long teamId,@RequestBody Player player) {
        Team team = teamRepository.findById(teamId).get();
        team.addPlayer(player);
        teamRepository.save(team);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
