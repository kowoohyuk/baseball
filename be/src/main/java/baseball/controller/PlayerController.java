package baseball.controller;

import baseball.domain.Player;
import baseball.dto.PlayerDto;
import baseball.dto.request.PlayerRequestDto;
import baseball.dto.request.TeamRequestDto;
import baseball.domain.Team;
import baseball.repository.TeamRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/players")
public class PlayerController{

    @PutMapping("/{playerId}")
    public ResponseEntity updatePlayer(@PathVariable Long playerId, @RequestBody PlayerRequestDto playerRequestDto) {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
