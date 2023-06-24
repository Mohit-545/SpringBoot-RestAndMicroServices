//ITouristMgmtImpl.java
package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Tourist;
import com.nt.error.TouristNotFoundException;
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

	@Override
	public List<Tourist> fetchAllTouristData() {
		List<Tourist> list = touristRepo.findAll();
		return list;
	}//method

	@Override
	public Tourist fetchTouristInfoById(int id) throws TouristNotFoundException {
		Tourist tourist = touristRepo.findById(id).orElseThrow(() -> new TouristNotFoundException("Tourist Details with id no : "+id+" Not Found"));
		return tourist;
	}//method

}//class
