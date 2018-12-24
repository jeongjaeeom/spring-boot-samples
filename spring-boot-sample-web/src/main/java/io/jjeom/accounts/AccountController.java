package io.jjeom.accounts;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jeongjae Eom
 * @since 2018-12-21
 */
@RestController("/accounts")
public class AccountController {

    @Autowired
    private AccountService service;

    @Autowired
    private AccountRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public String getAccount() {
        return "Hello Account";
    }

}
