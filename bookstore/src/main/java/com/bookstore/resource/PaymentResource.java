package com.bookstore.resource;

import com.bookstore.domain.User;
import com.bookstore.domain.UserBilling;
import com.bookstore.domain.UserPayment;
import com.bookstore.service.UserPaymentService;
import com.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentResource {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserPaymentService userPaymentService;

	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ResponseEntity addNewCreditCardPost (
			@RequestBody UserPayment userPayment,
			Principal principal) {
		User user = userService.findByUsername(principal.getName());
		
		UserBilling userBilling = userPayment.getUserBilling();
		
		userService.updateUserBilling(userBilling, userPayment, user);
		
		return new ResponseEntity("Payment Added(Updated) Successfully!", HttpStatus.OK);
	}
	
	@RequestMapping(value="/remove", method=RequestMethod.POST)
	public ResponseEntity removePaymentPost(
			@RequestBody String id,
			Principal principal
			){
//		User user = userService.findByUsername(principal.getName());
		
		userPaymentService.removeById(Long.valueOf(id));
		
		return new ResponseEntity("Payment Removed Successfully!", HttpStatus.OK);
	}
	
	@RequestMapping(value="/setDefault", method=RequestMethod.POST)
	public ResponseEntity setDefaultPaymentPost(
			@RequestBody String id,
			Principal principal
			){
		User user = userService.findByUsername(principal.getName());
		
		userService.setUserDefaultPayment(Long.parseLong(id), user);
		
		return new ResponseEntity("Payment Removed Successfully!", HttpStatus.OK);
	}
	
	@RequestMapping("/getUserPaymentList")
	public List<UserPayment> getUserPaymentList(
			Principal principal
			){
		User user = userService.findByUsername(principal.getName());

		return user.getUserPaymentList();
	}
	
}
