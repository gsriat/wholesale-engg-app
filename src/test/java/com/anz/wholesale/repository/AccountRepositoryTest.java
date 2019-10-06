package com.anz.wholesale.repository;

import com.anz.wholesale.domain.Account;
import com.anz.wholesale.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Test class for AccountRepository.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private AccountRepository accountRepository;

    @Test
    public void whenFindByCustomerId_shouldReturnAccounts() {

        Customer customer = new Customer();
        customer.setFirstName("Ashley");
        customer.setLastName("Jade");
        customer.setEmailId("ashley@demo.com");
        customer.setAddress("dummy Address");
        entityManager.persist(customer);

        Account account = new Account();
        account.setName("AUDAshleys895");
        account.setAvailableBal(new BigDecimal(8745.55));
        account.setCurrency("AUD");
        account.setType("Current");
        account.setCustomer(customer);

        entityManager.persist(account);

        List<Account> found  = accountRepository.findAllAccountsByCustomerId(customer.getId());

        assertEquals(found.size(), 1);
    }
}
