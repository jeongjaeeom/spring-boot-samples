package io.jjeom.security;

import io.jjeom.accounts.Account;
import io.jjeom.accounts.AccountRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Jeongjae Eom
 * @since 2018-12-21
 */
@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    private AccountRepository accountRepository;

    public UserDetailsServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByUsername(username);

        if (account == null) {
            throw new UsernameNotFoundException(username);
        }
        return new SignedUser(account);
    }
}
