package com.humanresource.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.humanresource.hrworker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

	
	
}
