package com.cg.orb.ui;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import com.cg.orb.Exception.RoomRegistrationException;
import com.cg.orb.dto.FlatRegistrationDTO;
import com.cg.orb.service.IRoomRegistrationService;
import com.cg.orb.service.RoomRegistrationServiceImpl;

public class Client {
	static FlatRegistrationDTO details=null;
	static IRoomRegistrationService service=null;
	//static Scanner sc=null;
public static void main(String[] args) throws RoomRegistrationException, IOException, SQLException{
	
	

Scanner s=new Scanner(System.in);	
int choice=0;

System.out.println("Room Booking Application\n*************");
System.out.println("1.Booking Room");
System.out.println("2.Exit");
System.out.println("enter your choice");

while(true){
	choice=s.nextInt();
	switch(choice){
	case 1:addBookingDetails();
	break;
	case 2:System.exit(0);
	break;
	default:System.out.println("ERROR");
					}
}
}
private static void addBookingDetails() throws RoomRegistrationException, IOException, SQLException {
	service= new RoomRegistrationServiceImpl();
	Scanner a=new Scanner(System.in);
	
	System.out.println("Existing HotelOwnerIDS Are:-[1, 2, 3]\nPlease enter your hotel owner id  from above list: ");
	int hotel_id=a.nextInt();
	
	System.out.println("Select  room type Type\n1-AC \n2-NON-AC): ");
	int roomtype=a.nextInt();
	
	System.out.println("Enter room area in sq.ft: ");
	long area=a.nextLong();
	
	System.out.println("Enter desired rent amount Rs: ");
	double rent_amt=a.nextDouble();
	
	System.out.println("Enter desired paid amount Rs:  ");
	double paid_amt=a.nextDouble();
	
	details=new FlatRegistrationDTO(hotel_id,roomtype,area,rent_amt,paid_amt);
	
	int res=service.addBookingDetails(details);
	System.out.println("Room successfully registered. Room no:"+res);
	
/*if(res>1)
{
	
}
else{System.out.println("value not added");}*/

}
}