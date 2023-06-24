//ITouristMgmt.java
package com.nt.service;

import java.util.List;

import com.nt.entity.Tourist;
import com.nt.error.TouristNotFoundException;

public interface ITouristMgmtService {
	
	public String enrollTouristDetails(Tourist tourist);
	public List<Tourist> fetchAllTouristData();
	public Tourist fetchTouristInfoById(int id)throws TouristNotFoundException;

}//interface
