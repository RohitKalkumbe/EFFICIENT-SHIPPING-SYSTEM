package com.app.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

//import org.springframework.web.bind.annotation.RestController;
import com.app.main.model.*;
import com.app.main.service.LoginService;


@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/home")
@Controller
public class LoginController {
	
	@Autowired
	LoginService loginservice;
	
	
	@PostMapping("/customer") 
	  public ResponseEntity<?> CustomerRegistration(@RequestBody Customer customer) {

		System.out.println("Calling customer method  ");
		System.out.println("Calling customer method  :-"+customer.getC_first_name()
				+"  Last Name"+customer.getC_last_name()+ " Emai:-"+customer.getC_email_id());
				return loginservice.saveCustomer(customer);
		
	}
	
	@PostMapping("/transporter") 
	  public ResponseEntity<?> CustomerRegistration(@RequestBody Transporter transporter) {

		System.out.println("Save Transapotr Method called");
		System.out.println("First Name:- "+transporter.getT_first_name()+ " Last Name:-"+transporter.getT_last_name() + "Mail_Id:-"+	transporter.getT_email_id());
			return loginservice.saveTransporter(transporter);		 	  
	}
	
	
	@PostMapping("/custlogin") 
	public ResponseEntity<Customer> CustomerLogin(@RequestBody Customer customer ) {

		loginservice.startMethod();
		return loginservice.validateCustomer(customer); 
	  }
	 
	@PostMapping("/translogin")
	public ResponseEntity<Transporter> TransporterLogin(@RequestBody Transporter transporter) {

		loginservice.startMethod();
		return loginservice.validateTransporter(transporter);
	}
	
	
	
	@PostMapping("/adminlogin")
	public ResponseEntity<Admin> AdminLogin(@RequestBody Admin admin) {

		loginservice.startMethod();
		return loginservice.validateAdmin(admin);
	}
	
}
