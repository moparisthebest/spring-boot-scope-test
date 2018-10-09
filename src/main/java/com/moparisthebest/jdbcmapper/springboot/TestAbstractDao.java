package com.moparisthebest.jdbcmapper.springboot;

public abstract class TestAbstractDao implements AutoCloseable {
    abstract String getIt();
}
