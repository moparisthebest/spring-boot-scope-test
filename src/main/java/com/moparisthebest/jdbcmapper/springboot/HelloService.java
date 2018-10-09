package com.moparisthebest.jdbcmapper.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.time.Instant;

@RestController
@Singleton
public class HelloService {

    private final TestDao testDao;
    private final TestAbstractDao testAbstractDao;

    @Inject
    public HelloService(TestDao testDao, TestAbstractDao testAbstractDao) {
        this.testDao = testDao;
        this.testAbstractDao = testAbstractDao;
    }

    // try this for 3 simultaneous requests:
    // curl http://localhost:8080/ & curl http://localhost:8080/ & curl http://localhost:8080/
    @RequestMapping("/")
    public String index() throws InterruptedException {
        System.out.println("index called: " + Instant.now());
        Thread.sleep(10000);
        System.out.println("index returning: " + Instant.now());
        return "Greetings from Spring Boot: " + testDao.getIt() + "<br/>" + testDao.getIt();
    }

    // try this for 3 simultaneous requests:
    // curl http://localhost:8080/a & curl http://localhost:8080/a & curl http://localhost:8080/a
    @RequestMapping("/a")
    public String a() throws InterruptedException {
        System.out.println("a called: " + Instant.now());
        Thread.sleep(10000);
        System.out.println("a returning: " + Instant.now());
        return "Greetings from Spring Boot: " + testAbstractDao.getIt() + "<br/>" + testAbstractDao.getIt();
    }
}
