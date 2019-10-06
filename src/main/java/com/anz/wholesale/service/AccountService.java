package com.anz.wholesale.service;

import com.anz.wholesale.domain.Account;

import java.util.List;

/**
 * Interface to add Account service queries.
 */
public interface AccountService {

    List<Account> findAllAccountsByCustomerId(final Long customerId);
}
