//ITouristMgmtImpl.java
package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Tourist;
import com.nt.repository.ITouristRepo;

@Service("/touristService")
public class TouristMgmtServiceImpl implements ITouristMgmtService {
	@Autowired
	private ITouristRepo touristRepo;

	@Override
	public String enrollTouristDetails(Tourist tourist) {
		int idVal = touristRepo.save(tourist).getTId();
		return "Tourist details are saved with generated id no :: "+idVal;
	}//method

}//class
