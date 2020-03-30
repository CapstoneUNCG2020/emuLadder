package com.uncg.emuLadder.service;

import com.uncg.emuLadder.model.response.ContestData;
import com.uncg.emuLadder.model.response.ResponseData;
import com.uncg.emuLadder.repository.ContestPlayersRepository;
import com.uncg.emuLadder.repository.ContestsRepository;
import com.uncg.emuLadder.repository.PlayersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ContestDataService implements IService<Integer, ResponseData<ContestData>> {

    private final ContestsRepository contestsRepository;
    private final PlayersRepository playersRepository;
    private final ContestPlayersRepository contestPlayersRepository;

    @Override
    public ResponseData<ContestData> service(Integer requestData) {
        ResponseData<ContestData> responseData = new ResponseData<>();

        return responseData;
    }

    @Autowired
    public ContestDataService(final ContestsRepository contestsRepository,
                              final PlayersRepository playersRepository,
                              final ContestPlayersRepository contestPlayersRepository) {
        this.contestsRepository = contestsRepository;
        this.playersRepository = playersRepository;
        this.contestPlayersRepository = contestPlayersRepository;
    }
}
