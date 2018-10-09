package com.moparisthebest.jdbcmapper.springboot;

import java.time.Instant;

@org.springframework.stereotype.Repository
@org.springframework.context.annotation.Scope(
        scopeName = org.springframework.web.context.WebApplicationContext.SCOPE_REQUEST,
        proxyMode = org.springframework.context.annotation.ScopedProxyMode.INTERFACES)
public class TestDaoBean implements TestDao {

    public TestDaoBean() {
        System.out.println("called TestDaoBean()" + this);
    }

    @Override
    public String getIt() {
        final String ret = "TestDaoBean.getIt(" + Instant.now() + ")";
        System.out.println("called " + ret + this);
        return ret;
    }

    @Override
    public void close() throws Exception {
        System.out.println("called TestDaoBean.close()" + this);
    }
}
