package baseball.controller;

import baseball.domain.Team;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import baseball.repository.TeamRepository;

@RestController
public class TeamController {

    private TeamRepository teamRepository;

    public TeamController(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @PostMapping
    ResponseEntity createTeam(@RequestBody Team team) {
        teamRepository.save(team);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
