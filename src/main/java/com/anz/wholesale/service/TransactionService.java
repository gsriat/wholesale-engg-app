package com.anz.wholesale.service;

import com.anz.wholesale.domain.Transaction;

import java.util.List;

/**
 * Interface to add Transaction service queries.
 */
public interface TransactionService {

    List<Transaction> findAll(Long accountNumber);
}
