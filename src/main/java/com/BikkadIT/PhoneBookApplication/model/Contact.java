package com.BikkadIT.PhoneBookApplication.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CONTACT_DTLS")
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CONTACT_ID")
	private Integer  contactId;
	@Column(name="CONTACT_NAME")
	private String contactName;
	@Column(name="CONTACT_NUMBER")
	private Long contactNumber;
	@Column(name="CONTACT_EMAIL")
	private String contactEmail;
	@Column(name="ACTIVE_SW")
	private Character activeSw;
	@Column(name="CREATED_DATE")
	private LocalDate createdDate;
	@Column(name="UPDATED_DATE")
	private LocalDate updatedDate;
	
}
