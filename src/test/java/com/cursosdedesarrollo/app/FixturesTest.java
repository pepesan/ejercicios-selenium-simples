package com.cursosdedesarrollo.app;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FixturesTest {
    @BeforeAll
    static public void before(){
        System.out.println("before all");
    }
    @BeforeEach
    public void beforeEach(){
        System.out.println("before each");
    }
    @Test
    public void miTest(){
        System.out.println("test 1");
        assertTrue(true);
    }
    @Test
    public void miTest2(){
        System.out.println("test 2");
    }
    @AfterAll
    static public void afterAll(){
        System.out.println("afterAll");
    }
    @AfterEach
    public void afterEach(){
        System.out.println("afterEach");
    }

}
