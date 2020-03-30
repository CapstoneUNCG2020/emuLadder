package com.uncg.emuLadder.service;

import com.uncg.emuLadder.model.response.ContestData;
import com.uncg.emuLadder.model.response.ResponseData;
import org.springframework.stereotype.Component;

@Component
public class ContestDataService implements IService<Integer, ResponseData<ContestData>> {

    @Override
    public ResponseData<ContestData> service(Integer requestData) {
        return null;
    }
}
