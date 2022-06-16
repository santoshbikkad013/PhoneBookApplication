package com.BikkadIT.PhoneBookApplication.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.BikkadIT.PhoneBookApplication.model.Contact;
import com.BikkadIT.PhoneBookApplication.service.ContactServiceI;

@RestController
public class ContactController {

	@Autowired
	private ContactServiceI contactServiceI;
	
	@PostMapping(value="/saveContact",consumes = "APPLICATION/JSON")
	public ResponseEntity<String> saveContact(@RequestBody Contact contact){
	
		boolean save=contactServiceI.saveContact(contact);
		if(save == true) {
			String msg="Contact Saved Successfully";
			return new ResponseEntity<String>(msg,HttpStatus.CREATED);
		}else {
			String msg="Contact Not Saved Successfully";
			return new ResponseEntity<String>(msg,HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(value="/getAllContact",produces = "APPLICATION/JSON")
	public ResponseEntity<List<Contact>> getAllContact(){
	
		List<Contact> list = contactServiceI.getAllContact();
		
		if(list !=null) {
			return new ResponseEntity<List<Contact>> (list,HttpStatus.OK);
		}else
		{
			String msg="Data Not found";
		return new ResponseEntity(msg,HttpStatus.BAD_REQUEST);
		}
	}
	
	
	
}
