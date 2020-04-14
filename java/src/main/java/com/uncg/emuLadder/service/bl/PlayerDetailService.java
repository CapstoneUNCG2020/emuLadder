package com.uncg.emuLadder.service.bl;

import com.uncg.emuLadder.model.database.ContestPlayers;
import com.uncg.emuLadder.model.database.Players;
import com.uncg.emuLadder.model.response.Player;
import com.uncg.emuLadder.repository.ContestPlayersRepository;
import com.uncg.emuLadder.repository.PlayersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PlayerDetailService {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final PlayersRepository playersRepository;
    private final ContestPlayersRepository contestPlayersRepository;

    @Autowired
    public PlayerDetailService(
            final PlayersRepository playersRepository,
            final ContestPlayersRepository contestPlayersRepository
    ) {
        this.playersRepository = playersRepository;
        this.contestPlayersRepository = contestPlayersRepository;
    }

    /**
     * Get details of Player by their unique player ID.
     * @param playerId - Unique Player ID
     * @return - Player { image, name, role, rank, salary }
     */
    public Player getPlayerDetails(String playerId) {
        /* Attempt to get database info on the player */
        Optional<Players> optional = playersRepository.findById(playerId);

        if (!optional.isPresent()) {
            logger.error("Invalid player ID: {}", playerId);
            return null;
        }

        Players dbPlayer = optional.get();

        // Convert to Player object needed by UI
        Player player = new Player();

        player.setImage(dbPlayer.getImage());
        player.setName(dbPlayer.getFirstName() + " " + dbPlayer.getLastName());
        player.setRole(dbPlayer.getRole());
        player.setSalary(dbPlayer.getSalary());

        return player;
    }

    public Player[] getPlayers(int contestId) {
        List<ContestPlayers> contestPlayersList = contestPlayersRepository.findAllByContestId(contestId);
        Player[] players = new Player[contestPlayersList.size()];

        for (int i = 0; i < players.length; i++) {
            String playerId = contestPlayersList.get(i).getPlayerId();
            players[i] = getPlayerDetails(playerId);

            int rank = getRank(contestId, playerId);
            players[i].setRank(rank);
        }

        return players;
    }

    /**
     * Get the rank of the player in the specified contest.
     *
     * @param contestId - Primary key for the contest
     * @param playerId - Primary key for the player
     * @return - int rank of the player in the contest
     */
    private int getRank(int contestId, String playerId) {
        Optional<ContestPlayers> optional = contestPlayersRepository.findByContestIdAndPlayerId(contestId, playerId);

        if (!optional.isPresent()) {
            logger.error("Error finding entry with contest ID {} and player ID {}", contestId, playerId);
            return -1;
        }

        ContestPlayers contestPlayers = optional.get();

        return contestPlayers.getRank();
    }
}
