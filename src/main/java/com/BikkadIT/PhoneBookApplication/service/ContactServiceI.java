package com.BikkadIT.PhoneBookApplication.service;

import java.util.List;

import com.BikkadIT.PhoneBookApplication.model.Contact;

public interface ContactServiceI {

	boolean saveContact(Contact contact);
	
	List<Contact> getAllContact();
	
	Contact getContactById(Integer cid);
	
	public boolean UpdateContact(Contact contact);
}
