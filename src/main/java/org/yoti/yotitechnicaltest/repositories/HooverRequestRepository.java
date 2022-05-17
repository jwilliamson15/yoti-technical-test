package org.yoti.yotitechnicaltest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yoti.yotitechnicaltest.models.HooverRequest;

@Repository
public interface HooverRequestRepository extends JpaRepository<HooverRequest, Long> {
}
