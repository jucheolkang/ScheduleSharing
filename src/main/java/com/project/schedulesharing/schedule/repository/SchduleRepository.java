package com.project.schedulesharing.schedule.repository;


import com.project.schedulesharing.schedule.entity.Schdule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchduleRepository extends JpaRepository<Schdule,Long> {
}
