package io.jjeom.commons.jpa;

import io.jjeom.accounts.Account;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author eomjeongjae
 * @since 2019-02-01
 */
@Component
public class SpringSecurityAuditorAware implements AuditorAware<Account> {

    public Optional<Account> getCurrentAuditor() {
        System.out.println("Looking for getCurrentAuditor by SpringSecurityAuditorAware");

        return Optional.ofNullable(SecurityContextHolder.getContext())
                .map(SecurityContext::getAuthentication)
                .filter(Authentication::isAuthenticated)
                .map(Authentication::getPrincipal)
                .map(Account.class::cast);
    }
}
