package org.jjeom.restapi.accounts;

import com.google.common.collect.Maps;
import org.jjeom.restapi.commons.jpa.Restrictions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author eomjeongjae
 * @since 2019-04-06
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountRepositoryTest {

    @Autowired
    private AccountRepository repository;

    @Test
    public void createAccount() {
        Map<String, Book> books = Maps.newHashMap();
        books.put("A", Book.builder().title("JPA책").author("김영한").build());


        Map<String, Phone> phones = Maps.newHashMap();
        phones.put("B", Phone.builder().number("01094251130").build());

        Account account = Account.builder()
                .username("jeongjaeeom")
                .books(books)
                .phones(phones)
                .build();

        Account save = repository.save(account);

        Account account1 = repository.findAll().get(0);

        Book a = account1.getBooks().get("A");
        System.out.println(a);

        Phone b = account1.getPhones().get("B");
        System.out.println(b);

        Restrictions restrictions = new Restrictions();
        restrictions.eq("username", "jeongjaeeom");
        restrictions.eq("phones", "jeongjaeeom");

        List<Account> all = repository.findAll(restrictions.output());
        System.out.println(all.size());
    }

}