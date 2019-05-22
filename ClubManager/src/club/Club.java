package club;

import java.util.ArrayList;
import java.util.HashMap;


public class Club {

	private int memberNumber;
//	private static Member[] memberArray = new Member[100];
	private ArrayList<Member> members = new ArrayList<Member>();
	private HashMap<String, Facility> facilities = new HashMap<String, Facility>();
	
	
	public Member addMember(String s, String f, String n) {
		memberNumber++;
		Member m = new Member(s, f, n, this.memberNumber);
		members.add(m);
		return m;
		
	}
	
	public Member addMember(String s, String f) {
		memberNumber++;
		Member m = new Member(s, f, this.memberNumber);
		members.add(m);
		return m;
		
	}
	
	public ArrayList<Member> getMemberArrayList() {
		return members;
	}
	
	public void showMembers() {
		for(Member member:members) {
			member.Show();	
		}
	}
	
	public void removeMember(int number) {
		members.remove(memberNumber-1);
	}
	
	
//Facility Methods
	
	public HashMap<String, Facility> getFacilities() {
		return facilities;
	}
	
	public Facility getFacility(String name) {
		
		Facility f = facilities.get(name);
		return f;
		
	}
	
	public void addFacility(String name, String desc) {
		Facility f = new Facility(name, desc);
		facilities.put(name,f);
	}
	
	
	public void removeFacility(String name) {
		facilities.remove(name);
	}
	
	public void showFacilities() {
		for (Facility facility: facilities.values()) {
			facility.Show();
		}
	}
	
	public void Show() {
		System.out.println("***FACILITIES***");
		showFacilities();
		System.out.println("***Members***");
		showMembers();
	}
	
}