package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

//... imports class definition...
public class AdminUser extends User implements HIPAACompliantAdmin, HIPAACompliantUser{

    
    // Inside class:
    private Integer employeeID;
    private String role;
    private ArrayList<String> securityIncidents;
    
    // TO DO: Implement a constructor that takes an ID and a role
    public AdminUser(Integer employeeID, String role) {
    	super(employeeID);
    	this.employeeID = employeeID;
    	this.role = role;
    	securityIncidents = new ArrayList<String>();
    }
    
    // TO DO: Implement HIPAACompliantUser!
    public boolean assignPin(int pin) {
		boolean verified = pin >= 100000;
		
		if(verified) {
			super.setPin(pin);
		}
		
		return verified;
	}
	
	public boolean accessAuthorized(Integer confirmedAuthID) {
		boolean match = confirmedAuthID == this.id;
		
		if(!match) {
			authIncident();
		}
		
		return match;
	}
    // TO DO: Implement HIPAACompliantAdmin!
	public ArrayList<String> reportSecurityIncidents(){
		return securityIncidents;
	}
	
    
    public void newIncident(String notes) {
        String report = String.format(
            "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
            new Date(), this.id, notes
        );
        securityIncidents.add(report);
    }
    public void authIncident() {
        String report = String.format(
            "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
            new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
        securityIncidents.add(report);
    }
    
    // TO DO: Setters & Getters
    public Integer getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
