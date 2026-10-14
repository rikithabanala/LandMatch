package com.example.LandMatch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.LandMatch.entity.Land;

public interface LandRepository extends JpaRepository<Land, Long> {
}
