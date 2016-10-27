package com.mindtree.Dao;

import com.mindtree.entity.Address;

public class AddressDaoImpl implements AddressDao {
	Address address1=new Address();  

	public void addAddress() {
		address1.setAddressLine1("229/1,Ashok nagar,Moolapalayam");  
	    address1.setCity("Erode");  
	    address1.setState("TN");  
	    address1.setCountry("India");  
	    address1.setPincode(6380002);    
	}

	public Address getAddress() {
		addAddress();
		return address1;
	}

}
