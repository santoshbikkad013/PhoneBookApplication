package com.BikkadIT.PhoneBookApplication.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import com.BikkadIT.PhoneBookApplication.model.Contact;

@RestController
public class ContactServiceImpl implements ContactServiceI {

	@Override
	public boolean saveContact(Contact contact) {
		// TODO Auto-generated method stub
		return false;
	}

}
