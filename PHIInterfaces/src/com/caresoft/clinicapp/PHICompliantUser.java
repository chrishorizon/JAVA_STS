package com.caresoft.clinicapp;

public interface PHICompliantUser {
	
	//ABSTRACT is a method that is declared without implementation
    // Expected to assign the pin to the user (as a member variable)
    abstract boolean assignPin(int pin);
    
    // Expected to compare instance id with id passed in. Returns true or false.
    abstract boolean isAuthorized(Integer confirmedAuthID);

}
