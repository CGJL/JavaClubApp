package club;


@SuppressWarnings("serial")
class BadBookingException extends Exception {
	
	
	BadBookingException() { 
		super("Invalid Bookings"); 
	}
	
	
	BadBookingException(String s) {
		super(s);
		}
}