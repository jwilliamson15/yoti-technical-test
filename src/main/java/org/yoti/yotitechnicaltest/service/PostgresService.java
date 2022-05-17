package org.yoti.yotitechnicaltest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yoti.yotitechnicaltest.models.HooverRequest;
import org.yoti.yotitechnicaltest.models.HooverResult;
import org.yoti.yotitechnicaltest.repositories.HooverRequestRepository;
import org.yoti.yotitechnicaltest.repositories.HooverResultRepository;

@Service
public class PostgresService implements DatabaseService {

    //TODO - create tables and test db!

    @Autowired
    private HooverRequestRepository requestRepo;
    @Autowired
    private HooverResultRepository resultRepo;

    @Override
    public void saveRequest(HooverRequest request) {
        requestRepo.save(request);
    }

    @Override
    public void saveResult(HooverResult result) {
        resultRepo.save(result);
    }
}
