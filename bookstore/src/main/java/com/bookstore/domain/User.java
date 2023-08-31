package com.bookstore.domain;

import com.bookstore.domain.security.Authority;
import com.bookstore.domain.security.UserRole;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
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
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements UserDetails, Serializable {

    private static final long serialVersionUID = 902783495L;

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column( name = "Id", nullable = false, updatable = false )
    private Long id;

    private String username;
    private String password;
    private String firstName;
    private String lastName;

    private String email;
    private String phone;
    private boolean enabled = true;

    @OneToMany( mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER )
    @JsonIgnore
    private Set<UserRole> userRoles = new HashSet<>();


    @OneToMany( cascade = CascadeType.ALL, mappedBy = "user" )
    private List<UserPayment> userPaymentList;

    @OneToMany( cascade = CascadeType.ALL, mappedBy = "user" )
    private List<UserShipping> userShippingList;


    @OneToOne( cascade = CascadeType.ALL, mappedBy = "user" )
    private ShoppingCart shoppingCart;

    @OneToMany( mappedBy = "user" )
    private List<Order> orderList;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Set<GrantedAuthority> authorities = new HashSet<>();
        userRoles.forEach(ur -> authorities.add(new Authority(ur.getRole().getName())));

        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

}
