package org.yoti.yotitechnicaltest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yoti.yotitechnicaltest.models.HooverRequest;
import org.yoti.yotitechnicaltest.models.HooverResult;
import org.yoti.yotitechnicaltest.repositories.HooverRequestRepository;
import org.yoti.yotitechnicaltest.repositories.HooverResultRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PostgresService implements DatabaseService {

    @Autowired
    private HooverRequestRepository requestRepo;
    @Autowired
    private HooverResultRepository resultRepo;

    @Override
    public void saveRequest(HooverRequest request) {
        requestRepo.saveAndFlush(request);
        log.info("Write to request table");
    }

    @Override
    public void saveResult(HooverResult result) {
        resultRepo.saveAndFlush(result);
        log.info("Write to result table");
    }
}
