package com.bookstore.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCart implements Serializable{
	
	private static final long serialVersionUID = -891273432L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private BigDecimal GrandTotal;
	
	@OneToMany(mappedBy = "shoppingCart", cascade= CascadeType.ALL, fetch= FetchType.LAZY)
	@JsonIgnore
	private List<CartItem> cartItemList;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private User user;

}
