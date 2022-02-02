package com.zee.zee5app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zee.zee5app.dto.Series;

public interface SeriesRepo extends JpaRepository<Series, String> {

}
