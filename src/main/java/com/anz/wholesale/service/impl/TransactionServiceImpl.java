package com.anz.wholesale.service.impl;

import com.anz.wholesale.domain.Transaction;
import com.anz.wholesale.repository.TransactionRepository;
import com.anz.wholesale.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;


    @Override
    public List<Transaction> findAll(Long accountNumber) {
        return transactionRepository.findAllTransactions(accountNumber);
    }
}
