package club;

import java.util.HashMap;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;


public class BookingRegister {
private HashMap<Facility, ArrayList<Booking>> bookingReg; 
	
	
	public BookingRegister() {
		bookingReg = new HashMap<Facility, ArrayList<Booking>>();
		
	}
	
    public void addBooking (Member member, Facility facility, LocalDateTime startDate, LocalDateTime endDate)
				throws BadBookingException {
        Booking b = new Booking (member, facility, startDate, endDate);
        ArrayList<Booking> bookingList = bookingReg.get (facility);
        if (bookingList == null) {
        	bookingList = new ArrayList<Booking> ();
            bookingReg.put (facility, bookingList);
        } else {
            Iterator<Booking> i = bookingList.iterator ();
            while (i.hasNext ()) {
                Booking other = i.next();
                if (b.overlaps(other)) {
                    throw new BadBookingException ("New booking overlaps with existing one");
                }
            }
        }
        bookingList.add (b);
    }
	
	public void removeBooking(Booking booking) {
		ArrayList<Booking> bookingList = bookingReg.get(booking.getFacility());
		if (bookingList != null) {
			bookingList.remove(booking);
		}
	}
	
	public ArrayList<Booking> getBookings(Facility f, LocalDateTime sdate, LocalDateTime edate) {
		ArrayList<Booking> display = new ArrayList<Booking>();
		ArrayList<Booking> bookingList = bookingReg.get(f);
		if (bookingList != null) {
			Iterator<Booking> i = bookingList.iterator();
			while (i.hasNext()) {
				Booking booking = i.next();
				boolean earlier = sdate.isAfter(booking.getEndDate());
				boolean later = edate.isBefore(booking.getStartDate());
				if(!(earlier || later)) {
					display.add(booking);
				}
			}
		}
		return display;
	}
	

}