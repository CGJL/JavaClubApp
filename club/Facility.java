package club;

public class Facility {

	String name;
	String desc;
	 
	
	
	public Facility(String name, String desc) {
		this.name = name;
		this.desc = desc;
	}
	
	public Facility(String name) {
		this.name = name;
		
	}	
	
	public String toString() {
		String facDets;
		if (desc == null) {
			facDets = "Facility Name: " + name +"\n";
		}
		else {
			facDets = "Facility Name: " + name + "\nDescription: " + desc+ "\n";
		}
		return facDets;
	}
	
	public void Show() {
		String fDetails = toString();
	System.out.println(fDetails);
	}
}
