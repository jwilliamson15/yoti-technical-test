package org.yoti.yotitechnicaltest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yoti.yotitechnicaltest.models.HooverResult;

@Repository
public interface HooverResultRepository extends JpaRepository<HooverResult, Long> {
}
