package com.bookstore.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class CartItem implements Serializable {

    private static final long serialVersionUID = -189412481L;

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private Long id;
    private int qty;
    private BigDecimal subtotal;

    @OneToOne
    private Book book;

    @OneToMany( mappedBy = "cartItem" )
    @JsonIgnore
    private List<BookToCartItem> bookToCartItemList;

    @ManyToOne
    @JoinColumn( name = "shopping_cart_id" )
    @JsonIgnore
    private ShoppingCart shoppingCart;

    @ManyToOne
    @JoinColumn( name = "order_id" )
    @JsonIgnore
    private Order order;

}
