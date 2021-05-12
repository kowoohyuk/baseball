package baseball.service;

import baseball.domain.*;
import baseball.dto.GameDto;
import baseball.dto.request.ChangeGameTeamScoreDto;
import baseball.dto.request.GameTeamScoreDto;
import baseball.dto.response.PlayerResponseDto;
import baseball.repository.GameRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class GameService {

    private GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<GameDto> createGameDtoList(List<Team> teamList) {
        List<GameDto> gameDtoList = new ArrayList<>();
        Collections.shuffle(teamList);

        for (int i = 0; i < teamList.size() - 1; i += 2) {
            Game game = Game.of(teamList.get(i), teamList.get(i + 1));
            gameRepository.save(game);
            gameDtoList.add(GameDto.of(game));
        }
        return gameDtoList;
    }

    public Game findGameById(Long gameId) {
        return gameRepository.findById(gameId).orElseThrow(NullPointerException::new);
    }

    public GameTeamScore LastGameTeamScoreByIdAndTeamId(boolean playStatus, Long gameId, Long teamId) {
        if (playStatus) {
            return gameRepository.findLastGameTeamScoreByIdAndTeamId(gameId, teamId).orElseThrow(NullPointerException::new);
        }
        return new GameTeamScore();
    }

    public boolean findPlayStatusById(Long gameId) {
        return gameRepository.findPlayStatusById(gameId);
    }

    public GamePlayerDetail gamePlayerDetailByPlayerId(Long gameId, Long playerId) {
        return gameRepository.gamePlayerDetailByPlayerId(gameId, playerId).orElseThrow(NullPointerException::new);
    }

    public List<PlayerResponseDto> createPlayerResponseDtoList(Long gameId, boolean playStatus, List<Player> team) {
        Game game = findGameById(gameId);
        List<PlayerResponseDto> playerResponseDtoList = new ArrayList<>();

        for (Player player : team) {
            Long playerId = player.getId();
            GamePlayerDetail gamePlayerDetail;

            if (!playStatus) {
                gamePlayerDetail = new GamePlayerDetail();
                gamePlayerDetail.setPlayerId(playerId);
                game.addPlayerDetail(gamePlayerDetail);
            } else {
                gamePlayerDetail = gamePlayerDetailByPlayerId(gameId, playerId);
            }

            PlayerResponseDto playerResponseDto = PlayerResponseDto.of(player, gamePlayerDetail);
            playerResponseDtoList.add(playerResponseDto);
        }
        /*gameRepository.save(game);*/
        return playerResponseDtoList;
    }

    public void isPlay(Long gameId) {
        gameRepository.isPlay(gameId);
    }

    public void updateGamePlayerDetail(Long playerId, Long gameId, Team team, boolean atBat) {
        Game game = findGameById(gameId);
        Player player = team.findPlayer(playerId);
        GamePlayerDetail gamePlayerDetail = game.findGamePlayerDetail(playerId);
        gamePlayerDetail.update(atBat);
        gameRepository.save(game);
    }

    public void createGameHomeTeamScore(ChangeGameTeamScoreDto changeGameTeamScoreDto) {
        Game game = findGameById(changeGameTeamScoreDto.getGameId());
        Long homeTeamId = game.getHome();
        Long awayTeamId = game.getAway();
        Long correctTeamId = (homeTeamId.equals(changeGameTeamScoreDto.getTeamId())) ? homeTeamId : awayTeamId;
        int round = changeGameTeamScoreDto.getRound();
        GameTeamScore gameTeamScore = GameTeamScore.of(++round);
        gameTeamScore.setTeamId(correctTeamId);
        game.addScores(gameTeamScore);
        gameRepository.save(game);
    }

    public void updateGameTeamScore(Long gameId, GameTeamScoreDto gameTeamScoreDto) {
        Game game = findGameById(gameId);
        int round = gameTeamScoreDto.getRound();

        GameTeamScore homeTeamScore = game.findGameTeamScore(round, game.getHome());
        GameTeamScore awayTeamScore = game.findGameTeamScore(round, game.getAway());

        if (gameTeamScoreDto.getTeamScore() == 0) {
            awayTeamScore.updateScore(gameTeamScoreDto.getAwayScore());
            game.addScores(awayTeamScore);
        }
        if (gameTeamScoreDto.getAwayScore() == 0) {
            homeTeamScore.updateScore(gameTeamScoreDto.getTeamScore());
            game.addScores(homeTeamScore);
        }
        gameRepository.save(game);
    }
}
