package com.bookstore.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class BillingAddress implements Serializable{
	private static final long serialVersionUID = 78293749582348L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String billingAddressName;
	private String billingAddressStreet1;
	private String billingAddressStreet2;
	private String billingAddressCity;
	private String billingAddressState;
	private String billingAddressCountry;
	private String billingAddressZipcode;
	
	@OneToOne
	@JsonIgnore
	private Order order;
}
