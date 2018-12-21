package io.jjeom.accounts;

import io.jjeom.commons.jpa.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

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
}
