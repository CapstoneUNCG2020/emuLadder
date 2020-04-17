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
import java.util.stream.Collectors;

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
     * @param dbPlayer - Database player object
     * @return - Player { image, name, role, rank, salary }
     */
    public Player getPlayerDetails(Players dbPlayer) {
        // Convert to Player object needed by UI
        Player player = new Player();

        player.setImage(dbPlayer.getImage());
        player.setName(dbPlayer.getFirstName() + " " + dbPlayer.getLastName());
        player.setRole(dbPlayer.getRole());
        player.setSalary(dbPlayer.getSalary());
        player.setPlayerId(dbPlayer.getPlayerId());

        return player;
    }

    public Player[] getPlayers(int contestId) {

        // Get a list of all Players in the contest
        List<ContestPlayers> contestPlayersList = contestPlayersRepository.findAllByContestId(contestId);

        // Create an array to store all the player information
        Player[] players = new Player[contestPlayersList.size()];

        // Convert list of all players to a list of all player IDs
        List<String> playerIdList = contestPlayersList.stream()
                .map(ContestPlayers::getPlayerId).collect(Collectors.toList());

        // Query DB for a list of all players who's ID in playerIdList
        List<Players> playerList = playersRepository.findAllByPlayerIdIn(playerIdList);

        // Convert DB Players object into UI Player object
        for (int i = 0; i < players.length; i++) {
            ContestPlayers contestPlayer = contestPlayersList.get(i);
            players[i] = getPlayerDetails(playerList.get(i));

            int rank = contestPlayer.getRank();
            players[i].setRank(rank);
        }

        return players;
    }
}
