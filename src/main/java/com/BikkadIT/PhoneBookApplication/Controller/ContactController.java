package com.BikkadIT.PhoneBookApplication.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping("/edit/{cid}")
	public ResponseEntity<Contact> getContactById(@PathVariable Integer cid){
		Contact contact = contactServiceI.getContactById(cid);
		if(contact !=null) {
			return new ResponseEntity<Contact>(contact,HttpStatus.OK);
		}else {
			String s="Record not found";
			return new ResponseEntity(s,HttpStatus.BAD_REQUEST);
		}	
	}
	
	@PutMapping("/updateContact")
	public ResponseEntity<String> updateContact(Contact contact) {
	
		boolean contact2 = contactServiceI.UpdateContact(contact);
		if(contact2 ==true) {
			return new ResponseEntity<String>("Contact Updated SUccessfully",HttpStatus.OK);
		}else {
			String msg="Contact not Updated";
		return new ResponseEntity<String>(msg,HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/deleteContactById/{cid}")
	public String deleteContactById(@PathVariable("cid") Integer cid) {
		
		boolean deleteById = contactServiceI.deleteById(cid);
		if(deleteById ==true) {
			return "Record deleted Successfully";
		}else {
		return "Record not deleted";
		}
	}
	
	
}
