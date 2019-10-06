package com.anz.wholesale.service;

import com.anz.wholesale.domain.Account;
import com.anz.wholesale.domain.Customer;
import com.anz.wholesale.repository.AccountRepository;
import com.anz.wholesale.service.impl.AccountServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Test class for AccountServiceImpl
 */
@RunWith(SpringRunner.class)
public class AccountServiceImplTest {

    @TestConfiguration
    static class AccountServiceImplTestContextConfiguration {

        @Bean
        public AccountService accountService() {
            return new AccountServiceImpl();
        }
    }

    @Autowired
    private AccountService accountService;

    @MockBean
    private AccountRepository accountRepository;

    @Before
    public void setUp() {

        Customer customer = new Customer();
        customer.setId(987654l);
        customer.setFirstName("Ashley");
        customer.setLastName("Jade");
        customer.setEmailId("ashley@demo.com");
        customer.setAddress("dummy Address");

        Account account = new Account();
        account.setNumber(123456l);
        account.setName("AUDAshleys895");
        account.setAvailableBal(new BigDecimal(8745.55));
        account.setCurrency("AUD");
        account.setType("Current");
        account.setCustomer(customer);

        List<Account> accounts = new ArrayList<>();
        accounts.add(account);

        Mockito.when(accountRepository.findAllAccountsByCustomerId(customer.getId()))
                .thenReturn(accounts);
    }

    @Test
    public void whenValidCustomerId_thenAccountsShouldBeFound() {
        Long customerId = 987654l;
        List<Account> found = accountService.findAllAccountsByCustomerId(customerId);

        Assert.assertEquals(found.get(0).getCustomer().getId(), customerId);
    }

}
