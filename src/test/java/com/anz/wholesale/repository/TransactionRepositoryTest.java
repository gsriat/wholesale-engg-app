package com.anz.wholesale.repository;

import com.anz.wholesale.domain.Account;
import com.anz.wholesale.domain.Customer;
import com.anz.wholesale.domain.Transaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Test class for TransactionRepository.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class TransactionRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private TransactionRepository transactionRepository;

    @Test
    public void whenFindByAccountNumber_shouldReturnTransactions() {

        Customer customer = new Customer();
        customer.setFirstName("Ashley");
        customer.setLastName("Jade");
        customer.setEmailId("ashley@demo.com");
        customer.setAddress("dummy Address");
        entityManager.persist(customer);

        Account account = new Account();
        account.setName("AshleysAccount");
        account.setAvailableBal(new BigDecimal(8745.55));
        account.setCurrency("AUD");
        account.setType("Current");
        account.setCustomer(customer);
        entityManager.persist(account);

        Transaction transaction = new Transaction();
        transaction.setAccount(account);
        transaction.setCreditAmt(new BigDecimal(5642.25));
        transaction.setDebitCredit("Credit");
        transaction.setValueDate(LocalDate.now());

        entityManager.persist(transaction);

        List<Transaction> found  = transactionRepository.findAllTransactions(account.getNumber());

        assertEquals(found.size(), 1);
    }
}
