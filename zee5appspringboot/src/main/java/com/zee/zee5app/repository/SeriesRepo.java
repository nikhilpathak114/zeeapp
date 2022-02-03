package com.zee.zee5app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zee.zee5app.dto.Series;

@Repository
public interface SeriesRepo extends JpaRepository<Series, String> {
	Boolean existsBySeriesName(String seriesName);
	Optional<Series> findBySeriesNameAndLanguage(String seriesName,String language);
}
