package com.bal;

import java.util.ArrayList;

public class User {
	private String name;
	private String service;
	private ArrayList<Message> bal;
	private static int ID = 0;
	private int id;
	
	
	
	public User(String name, String service) {
		id = ID++;
		this.name = name;
		this.service = service;
		bal = new ArrayList<>();
	}
	
	public boolean available(){
	//	return true;
		if (id % 2 == 0)
			return true;
		return false;
	}
	
	public void notified(String idMessage){
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	
	public void receive(Message m){
		bal.add(m);
	}
	
	public void display(){
		System.out.println("user " + name + " receive :");
		for (Message m : bal)
			System.out.println(m);
	}
	
}
