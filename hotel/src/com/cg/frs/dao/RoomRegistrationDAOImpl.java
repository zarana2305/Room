package com.cg.frs.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cg.orb.DBUtil.RoomDBUtil;
import com.cg.orb.Exception.RoomRegistrationException;
import com.cg.orb.dto.FlatRegistrationDTO;
import com.cg.orb.service.IRoomRegistrationService;



public class RoomRegistrationDAOImpl implements IRoomRegistrationService {

	
//Connection conn=null;
	
	public int addBookingDetails(FlatRegistrationDTO p) throws RoomRegistrationException {
		
		int result=0;
		int result1=0; 
		Connection conn=null;
		
		try{
		conn=RoomDBUtil.getConnection();
		String insertQuery="Insert into Room_Registration values(room_SEQ.nextval,?,?,?,?,?)";
		PreparedStatement ps=conn.prepareStatement(insertQuery);
		
		
		
		ps.setInt(1,p.getHotel_id());
		ps.setInt(2,p.getRoomtype());
		ps.setLong(3,p.getArea());
		ps.setDouble(4, p.getRent_amt());
		ps.setDouble(5, p.getPaid_amt());
		result = ps.executeUpdate();
		System.out.println(result);
		
		String sql="Select room_SEQ.currval from Room_Registration";
		Statement ps1=conn.createStatement();
		ResultSet rs=ps1.executeQuery(sql);
		//to get the room number 
		while(rs.next()){
		result1=rs.getInt(1);//gets the value of column 1 value
		}

		}
		
		catch(IOException a){
			a.printStackTrace();

		}
		catch(SQLException e){

			throw new RoomRegistrationException(e.getMessage());
		}
		return result1;
		}
	
	}

