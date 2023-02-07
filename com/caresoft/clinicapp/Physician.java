package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

//... imports class definition...
public class Physician extends User implements HIPAACompliantUser{
	
    
    // Inside class:    
    private ArrayList<String> patientNotes;
	
    // TODO: Constructor that takes an ID
	public Physician(Integer id) {
		super(id);
	}
	// TODO: Implement HIPAACompliantUser!
	public boolean assignPin(int pin) {
		boolean verified = pin >= 1000 && pin <= 9999;
		
		if(verified) {
			super.setPin(pin);
		}
		
		return verified;
	}
	
	public boolean accessAuthorized(Integer confirmedAuthID) {
		return confirmedAuthID == this.id;
	}
	
    public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }


	
    // TO DO: Setters & Getters
}

