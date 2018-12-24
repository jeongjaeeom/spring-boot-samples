package io.jjeom.accounts;

import io.jjeom.commons.jpa.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * @author Jeongjae Eom
 * @since 2018-12-21
 */
@Getter
@Setter
@ToString(callSuper = true)
@Entity
public class Role extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private RoleName name;

    public enum RoleName {
        ADMIN, USER
    }

}
