//ITouristRepo.java
package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.nt.entity.Tourist;

import jakarta.transaction.Transactional;

public interface ITouristRepo extends JpaRepository<Tourist, Integer> {
	@Modifying
	@Transactional
	@Query("delete from Tourist where budget>=:start and budget<=:end")
	public int removeTouristByBudgetRange(double start, double end);

}//interface
