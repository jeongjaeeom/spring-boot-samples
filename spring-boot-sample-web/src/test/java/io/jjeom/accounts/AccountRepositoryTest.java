package io.jjeom.accounts;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Jeongjae Eom
 * @since 2019-01-02
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountRepositoryTest {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountRoleRepository accountRoleRepository;

    @Test
    public void ddl() {
        System.out.println("OK");
    }

    @Test
    @Rollback(false)
    public void addAccount() {
        Account adminAccount = Account.builder()
                .username("admin")
                //.password(passwordEncoder.encode("a123456A"))
                .email("jeongjae.eom@gmail.com")
                .build();
        adminAccount.addRole(AccountRole.builder().role(Role.ADMIN).build());
        adminAccount.addRole(AccountRole.builder().role(Role.USER).build());
        accountRepository.save(adminAccount);
    }
}
