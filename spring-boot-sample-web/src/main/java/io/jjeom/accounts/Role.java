package io.jjeom.accounts;

import io.jjeom.commons.jpa.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

/**
 * @author Jeongjae Eom
 * @since 2018-12-21
 */
@Getter
@Setter
@Entity
public class Role extends BaseEntity {

    private String name;

}
