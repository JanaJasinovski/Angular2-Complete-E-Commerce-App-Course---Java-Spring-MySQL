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
public class ShippingAddress implements Serializable{
	
	private static final long serialVersionUID = 189013457L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String shippingAddressName;
	private String shippingAddressStreet1;
	private String shippingAddressStreet2;
	private String shippingAddressCity;
	private String shippingAddressState;
	private String shippingAddressCountry;
	private String shippingAddressZipcode;
	
	@OneToOne
	@JsonIgnore
	private Order order;
}
