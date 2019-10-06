package com.anz.wholesale.service;

import com.anz.wholesale.domain.Account;
import com.anz.wholesale.domain.Customer;
import com.anz.wholesale.domain.Transaction;
import com.anz.wholesale.repository.TransactionRepository;
import com.anz.wholesale.service.impl.TransactionServiceImpl;
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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Test class for TransactionServiceImpl
 */
@RunWith(SpringRunner.class)
public class TransactionServiceImplTest {

    @TestConfiguration
    static class TransactionServiceImplTestContextConfiguration {

        @Bean
        public TransactionService transactionService() {
            return new TransactionServiceImpl();
        }
    }

    @Autowired
    private TransactionService transactionService;

    @MockBean
    private TransactionRepository transactionRepository;

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

        Transaction transaction = new Transaction();
        transaction.setAccount(account);
        transaction.setCreditAmt(new BigDecimal(5642.25));
        transaction.setDebitCredit("Credit");
        transaction.setValueDate(LocalDate.now());

        List<Transaction> transactions = new ArrayList<>();
        transactions.add(transaction);

        Mockito.when(transactionRepository.findAllTransactions(account.getNumber()))
                .thenReturn(transactions);
    }

    @Test
    public void whenValidAccountNumber_thenTransactionsShouldBeFound() {
        Long acctNumber = 123456l;
        List<Transaction> found = transactionService.findAll(acctNumber);

        Assert.assertEquals(found.get(0).getAccount().getNumber(), acctNumber);
    }
}
