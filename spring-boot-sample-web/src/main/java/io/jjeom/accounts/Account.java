package io.jjeom.accounts;

import com.google.common.collect.Sets;
import io.jjeom.commons.jpa.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

/**
 * @author Jeongjae Eom
 * @since 2018-12-20
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Account extends BaseEntity {

    @Column(unique = true, nullable = false)
    private String username;

    private String password;

    private String email;

    @Builder.Default
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "account_roles", joinColumns = @JoinColumn(name = "account_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Set<AccountRole> roles = Sets.newHashSet();

    public void addRole(AccountRole role) {
        this.getRoles().add(role);
        role.getAccounts().add(this);
    }

    public void removeRole(AccountRole role) {
        this.getRoles().remove(role);
        role.getAccounts().remove(this);
    }
}
