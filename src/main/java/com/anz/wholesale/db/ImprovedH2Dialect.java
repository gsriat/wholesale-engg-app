package com.anz.wholesale.db;

import org.hibernate.dialect.H2Dialect;

/**
 * Workaround.
 *
 * @see https://hibernate.atlassian.net/browse/hhh-7002
 *
 */
public class ImprovedH2Dialect extends H2Dialect {
    @Override
    public String getDropSequenceString(String sequenceName) {
        // Adding the "if exists" clause to avoid warnings
        return "drop sequence if exists " + sequenceName;
    }

    @Override
    public boolean dropConstraints() {
        // We don't need to drop constraints before dropping tables, that just
        // leads to error messages about missing tables when we don't have a
        // schema in the database
        return false;
    }
}
