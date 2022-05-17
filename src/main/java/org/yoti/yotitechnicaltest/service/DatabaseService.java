package org.yoti.yotitechnicaltest.service;

import org.yoti.yotitechnicaltest.models.HooverRequest;
import org.yoti.yotitechnicaltest.models.HooverResult;

public interface DatabaseService {

    public void saveRequest(HooverRequest request);
    public void saveResult(HooverResult result);
}
