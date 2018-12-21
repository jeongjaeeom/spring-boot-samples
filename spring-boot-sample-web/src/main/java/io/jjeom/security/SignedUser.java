package io.jjeom.security;

import io.jjeom.accounts.Account;
import io.jjeom.accounts.Role;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Jeongjae Eom
 * @since 2018-12-21
 */
@Getter
public class SignedUser extends User {

    private Account account;

    public SignedUser(Account account) {
        super(account.getUsername(), account.getPassword(), authorities(account.getRoles()));
        this.account = account;
    }

    private static Collection<? extends GrantedAuthority> authorities(Set<Role> roles) {
        return roles.stream()
                .map(r -> new SimpleGrantedAuthority("ROLE_" + r.getName()))
                .collect(Collectors.toSet());
    }

}
