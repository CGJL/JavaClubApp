package club;


import java.time.LocalDateTime;


public class Booking {
	private LocalDateTime start_date = LocalDateTime.now();
	private LocalDateTime end_date = LocalDateTime.now();
	private Member m;
	private Facility f;
	
	
	public Booking(Member mem, Facility fac, LocalDateTime sd, LocalDateTime ed) throws BadBookingException {
		if (mem == null) throw new BadBookingException("Please enter member details");
		if (fac == null) throw new BadBookingException("Please enter facility");
		if (sd.toString()==null || ed.toString() == null) throw new BadBookingException("Please check start/end date");
		if (ed.isBefore(sd)) throw new BadBookingException("Start Date is after End Date");
	
		m = mem;
		f= fac;
		start_date = sd;
		end_date = ed;
	}
	
	public Member getMember() {
		return m;
	}
	
	public Facility getFacility() {
		return f;
	}
	
	public LocalDateTime getStartDate() {
		return start_date;
	}
	
	public LocalDateTime getEndDate() {
		return end_date;
	}
	
	
	public boolean overlaps(Booking b) {
		boolean overlap = false;
		if (start_date.isBefore(b.end_date)  && end_date.isAfter(b.start_date)) { 
			overlap = true;
		}
		else {
			overlap = false;
		}
		return overlap;
	}
	
	public String toString() {
		String booker;
		if (m.secondName != null) {
			 booker = "Name: " + m.firstName +" " + m.secondName + " "+ m.surname + "\n";
		}
		else { 
			booker = "Name: " + m.firstName + " "+ m.surname + "\n";
		}
		
		String faci = "Facility: " + f.name + "\n";
		String sdate = "Start: " + start_date.toString() + "\n";
		String edate = "End: " + end_date.toString();
		
		return booker + faci + sdate + edate;
	}
	public void Show() {
		System.out.println(toString());
	}
	

	
}