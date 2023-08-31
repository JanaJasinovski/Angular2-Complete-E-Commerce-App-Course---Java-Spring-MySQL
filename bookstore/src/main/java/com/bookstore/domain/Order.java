package com.bookstore.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_order")
public class Order implements Serializable{
	
	private static final long serialVersionUID = 2893475845L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Date orderDate;
	private Date shippingDate;
	private String shippingMethod;
	private String orderStatus;
	private BigDecimal orderTotal;
	
	@OneToMany(mappedBy = "order", cascade= CascadeType.ALL)
	private List<CartItem> cartItemList;
	
	@OneToOne(cascade=CascadeType.ALL)
	private ShippingAddress shippingAddress;
	
	@OneToOne(cascade=CascadeType.ALL)
	private BillingAddress billingAddress;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Payment payment;
	
	@ManyToOne
	@JsonIgnore
	private User user;

}
