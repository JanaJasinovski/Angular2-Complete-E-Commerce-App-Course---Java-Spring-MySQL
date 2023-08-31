package com.bookstore.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserBilling implements Serializable{
	private static final long serialVersionUID = 79872894528934L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String userBillingName;
	private String userBillingStreet1;
	private String userBillingStreet2;
	private String userBillingCity;
	private String userBillingState;
	private String userBillingCountry;
	private String userBillingZipcode;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private UserPayment userPayment;
	
}
