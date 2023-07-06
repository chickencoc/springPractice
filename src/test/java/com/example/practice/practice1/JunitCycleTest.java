package com.example.practice.practice1;

import org.junit.jupiter.api.*;

public class JunitCycleTest {
    @BeforeAll
    static void beforeAll() {
        System.out.println("@BeforAll");
    }
    @BeforeEach
    public void beforeEach() {
        System.out.println("@BeforeEach");
    }
    @DisplayName("test1")
    @Test
    public void test1() {
        System.out.println(">>>> test1");
    }
    @DisplayName("test2")
    @Test
    public void test2() {
        System.out.println(">>>> test2");
    }
    @DisplayName("test3")
    @Test
    public void test3() {
        System.out.println(">>>> test3");
    }
    @AfterAll
    static void afterAll() {
        System.out.println("@AfterAll");
    }
    @AfterEach
    public void afterEach() {
        System.out.println("@AfterEach");
    }



}
