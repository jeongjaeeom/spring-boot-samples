package io.jjeom.accounts;

import com.google.common.collect.Sets;
import io.jjeom.commons.jpa.AuditableEntity;
import io.jjeom.commons.jpa.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

/**
 * @author Jeongjae Eom
 * @since 2018-12-21
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class AccountRole extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private Role role;

    @Builder.Default
    @ManyToMany(mappedBy = "roles", cascade = CascadeType.ALL)
    private Set<Account> accounts = Sets.newHashSet();

}
