package io.jjeom.accounts;

import io.jjeom.commons.jpa.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

/**
 * @author Jeongjae Eom
 * @since 2018-12-20
 */
@Getter
@Setter
@ToString(callSuper = true)
@Entity
public class Account extends BaseEntity {

    @Column(unique = true)
    private String username;

    private String password;

    private String email;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "account_role", joinColumns = @JoinColumn(name = "account_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
}
