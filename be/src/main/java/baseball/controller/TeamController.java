package baseball.controller;

import baseball.domain.Team;
import baseball.repository.TeamRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeamController {

    private TeamRepository teamRepository;

    public TeamController(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @PostMapping("/team")
    public ResponseEntity createTeam(@RequestBody Team team) {
        teamRepository.save(team);
        return ResponseEntity.ok().body("성공");
    }
}
