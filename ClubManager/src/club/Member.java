package club;


public class Member {

	int memberNumber;
	String surname;
	String firstName;
	String secondName;
	
	public Member(String f, String s, String n, int mNumber) {
		f = firstName;
		s = surname;
		n = secondName;
		memberNumber = mNumber;
	
	}
	public Member(String f, String s, int mNumber) {
		f = firstName;
		s = surname;
		memberNumber = mNumber;
	
	}
	

	public String toString() {
		if (secondName == null) {
		String memberDetails = firstName +" "+ surname + " " + memberNumber; 
		return memberDetails;
		}
		else {
			String memberDetails = firstName +" " + secondName +" "+ surname + " " + memberNumber; 
			return memberDetails;
		}
	}
		
		public void Show() {
			String finalName = toString();
			System.out.println(finalName);
	}
	
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSecondName() {
		return secondName;
	}
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
	public void setMemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
	}
	public int getMemberNumber() {
		return memberNumber;
	}

	
}