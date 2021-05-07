package baseball.controller;

import baseball.dto.PlayerDTO;
import baseball.dto.TeamDTO;
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
    public ResponseEntity createPlayerList(@RequestBody TeamDTO teamDTO) {
        Team team = teamRepository.findById(teamDTO.getId()).get();
        for(PlayerDTO player : teamDTO.getPlayers()){
            team.addPlayer(player.toPlayer());
        }
        teamRepository.save(team);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
