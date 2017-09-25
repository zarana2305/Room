package com.cg.orb.service;

import java.io.IOException;
import java.sql.SQLException;

import com.cg.orb.Exception.RoomRegistrationException;
import com.cg.orb.dto.FlatRegistrationDTO;


public interface IRoomRegistrationService {

	int addBookingDetails(FlatRegistrationDTO details) throws RoomRegistrationException, IOException, SQLException;

	

	
	}