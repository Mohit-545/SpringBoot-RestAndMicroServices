//ITouristMgmtImpl.java
package com.nt.service;

import java.util.List;
import java.util.Optional;

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

	@Override
	public String updateTouristInfo(Tourist tourist) throws TouristNotFoundException {
		Optional<Tourist> opt = touristRepo.findById(tourist.getTId());
		if(opt.isPresent()) {
			touristRepo.save(tourist);
			return "Tourist Details are update with new Details";
		}//if
		else {
			throw new TouristNotFoundException("Tourist Details Not Found....!!!!");
		}//else
	}//method

	@Override
	public String updateTouristInfoById(int id, double hikePercentage) throws TouristNotFoundException {
		Optional<Tourist> opt = touristRepo.findById(id);
		if(opt.isPresent()) {
			Tourist tourist = opt.get();
			double budget = tourist.getBudget();
			double newBudget = budget+(budget*hikePercentage/100);
			tourist.setBudget(newBudget);
			touristRepo.save(tourist);
			return "Tourist Details are updated with new Details";
		}//if
		else
		throw new TouristNotFoundException("Tourist Details not found......!!!!!!!!!!");
	}//method

	@Override
	public String deleteTouristById(int id) throws TouristNotFoundException {
		Optional<Tourist> opt = touristRepo.findById(id);
		if(opt.isPresent()) {
			touristRepo.deleteById(id);
		return "Tourist Details with id :: "+id+" is deleted";
		}//if
		else
			throw new TouristNotFoundException("Tourist Details not found...!!!!!!!!!");
	}//method

	@Override
	public String deleteTouristByBudgetRange(double start, double end) {
		int count = touristRepo.removeTouristByBudgetRange(start, end);
		return count==0?"No Tourist Details found for deletion":count+" Tourist found and deleted";
	}//method
	
	
	

}//class
