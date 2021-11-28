package com.progmanda02_004.repositories;

import com.progmanda02_004.models.MatchModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<MatchModel, Long> {
}
