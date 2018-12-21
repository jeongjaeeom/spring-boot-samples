package io.jjeom.accounts;

import io.jjeom.commons.jpa.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

/**
 * @author Jeongjae Eom
 * @since 2018-12-20
 */
@Getter
@Setter
@Entity
public class Account extends BaseEntity {

    @Column(unique = true)
    private String username;

    private String password;

    private String email;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
}
