package club;


import java.time.LocalDateTime;
import java.time.format.*;

public class ClubApplication {

	int membershipNumber;
	public static void main(String[] args) throws BadBookingException{
		
		Club lions = new Club();
		Member Member1, Member2, Member3, Member4;
		
		Member1 = lions.addMember("Elton", "Janties");
		Member2 = lions.addMember("Malcom", "Marx");
		Member3 = lions.addMember("Kwagga", "Smith");
		Member4 = lions.addMember("Carlu", "Sadie", "C.");
		
		//Adding and deleting members
		System.out.println("--- deleting members ---");
		lions.showMembers();
		lions.removeMember(1);
		
	System.out.println("---member deleted---");
		lions.showMembers();
		System.out.println("--- adding members ---");
		lions.addMember("Warren", "Whitley");
		lions.showMembers();
		System.out.println(" ");
		
		//Facilities
		System.out.println("--- Facility testing ---");
		lions.addFacility("Pool", "A body of water");
		lions.addFacility("Massage Room", "A place to relax");
		lions.addFacility("Hot tub", "Hot tub time machine");
		lions.showFacilities();
		System.out.println(" ");
		
		
		//Test Booking
		DateTimeFormatter df = DateTimeFormatter.ofPattern("d-MMM-yyyy H:mm");
		
		try {
			Booking booking1 = new Booking(Member1, lions.getFacility("Pool"), LocalDateTime.parse("1-Aug-2007 07:00", df), LocalDateTime.parse("01-Aug-2007 08:00", df));
			booking1.Show();
			System.out.println();
			Booking booking2 = new Booking(Member4,lions.getFacility("Hot tub"),LocalDateTime.parse("1-Aug-2027 07:00", df), LocalDateTime.parse("01-Aug-2027 08:00", df));
			booking2.Show();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("booking1/2 done");
		
		//Test the exception (null member)
		System.out.println();
		
		try {
			Booking booking3 = new Booking(null, lions.getFacility("Pool"), LocalDateTime.parse("1-Aug-2007 07:00", df), LocalDateTime.parse("01-Aug-2007 08:00", df));
			booking3.Show();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("null member tested");
		System.out.println();
		
		//Test invalid facility
		try {
			Booking booking4 = new Booking(Member2, lions.getFacility("hot tub"), LocalDateTime.parse("1-Aug-2007 07:00", df), LocalDateTime.parse("01-Aug-2007 08:00", df));
			booking4.Show();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("invalid facility tested");
		System.out.println();
		
		
		//Test start date after end date error
		try {
			Booking booking5 = new Booking(Member3, lions.getFacility("Hot tub"), LocalDateTime.parse("1-Aug-2006 07:00", df), LocalDateTime.parse("01-Aug-2005 08:00", df));
			booking5.Show();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("endate before start date tested");
		System.out.println();
		
		//try to add overlapping booking
		
		try {
			BookingRegister reg = new BookingRegister();
			reg.addBooking(Member3, lions.getFacility("Pool"), LocalDateTime.parse("1-Aug-2007 07:30" ,df), LocalDateTime.parse("1-Aug-2007 09:00",df));
			reg.addBooking(Member4, lions.getFacility("Pool"), LocalDateTime.parse("1-Aug-2007 08:30" ,df), LocalDateTime.parse("1-Aug-2007 10:00",df));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("overlapping booking tested");
		
		
		
	
	
		
	}

}