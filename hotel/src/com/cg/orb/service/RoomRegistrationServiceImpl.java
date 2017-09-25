package com.cg.orb.service;



import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Pattern;

import com.cg.frs.dao.RoomRegistrationDAOImpl;
import com.cg.orb.Exception.RoomRegistrationException;
import com.cg.orb.dto.FlatRegistrationDTO;

public class RoomRegistrationServiceImpl implements IRoomRegistrationService {
	
	
	IRoomRegistrationService dao=null;

	public int addBookingDetails(FlatRegistrationDTO details) throws RoomRegistrationException, IOException, SQLException
	{
		dao=new RoomRegistrationDAOImpl();
		return dao.addBookingDetails(details);
	}

	
	
	public boolean validateid(int hotel_id){
		int a=hotel_id;
		if(a==1|2|3){
			return true;
		}
		else{
			System.out.println("Please enter valid data");
			return false;
		}

}
