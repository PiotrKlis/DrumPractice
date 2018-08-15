package com.drumpractice.external;

interface DbConnectionFactory<T> {
    T getDatabaseConnection();
}
