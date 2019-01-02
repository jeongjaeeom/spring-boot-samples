package io.jjeom.accounts;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Jeongjae Eom
 * @since 2019-01-02
 */

public interface AccountRoleRepository extends JpaRepository<AccountRole, Long> {
}
