package org.jjeom.restapi.accounts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author eomjeongjae
 * @since 2019-04-06
 */
public interface AccountRepository extends JpaRepository<Account, Long>, JpaSpecificationExecutor<Account> {

}
