package com.bookstore.domain.security;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role implements Serializable {

    private static final long serialVersionUID = 890245234L;

    @Id
    private int roleId;

    private String name;

    @OneToMany( mappedBy = "role", cascade = CascadeType.ALL, fetch = FetchType.LAZY )
    private Set<UserRole> userRoles = new HashSet<>();

}
