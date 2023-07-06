package com.example.practice.practice1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JunitTest {
    @DisplayName("TEST1")
    @Test
    public void junitTest1() {
        int a = 1;
        int b = 2;
        int sum = 3;
//        Assertions.assertEquals(a + b, sum);
        assertThat(a + b).isEqualTo(sum);

        String astr = "test1";
        assertThat(astr).contains("est");
    }
    @DisplayName("TEST2")
    @Test
    public void junitTest2() {
        int a = 1;
        int b = 3;
        int sum = 4;

        Assertions.assertEquals(a + b, sum);
    }
    @DisplayName("TEST3")
    @Test
    public void junitTest3() {
        int a = 1;
        int b = 3;
        int sum = 2;

        Assertions.assertEquals(a + b, sum);
    }

}
