package io.jjeom.accounts;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Jeongjae Eom
 * @since 2018-12-20
 */
public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByUsername(String username);
}
