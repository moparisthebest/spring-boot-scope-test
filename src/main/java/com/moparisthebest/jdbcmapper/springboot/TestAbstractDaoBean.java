package com.moparisthebest.jdbcmapper.springboot;

import java.time.Instant;

@org.springframework.stereotype.Repository
@org.springframework.context.annotation.Scope(
        scopeName = org.springframework.web.context.WebApplicationContext.SCOPE_REQUEST,
        proxyMode = org.springframework.context.annotation.ScopedProxyMode.TARGET_CLASS)
public class TestAbstractDaoBean extends TestAbstractDao {

    public TestAbstractDaoBean() {
        System.out.println("called TestAbstractDaoBean()" + this);
    }

    @Override
    public String getIt() {
        final String ret = "TestAbstractDaoBean.getIt(" + Instant.now() + ")";
        System.out.println("called " + ret + this);
        return ret;
    }

    @Override
    public void close() throws Exception {
        System.out.println("called TestAbstractDaoBean.close()" + this);
    }
}
