package com.ctco.testSchool.tests;

import com.ctco.testSchool.Team;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class GetPrimeNumberClosesToTest {

    @Test
    public void test_1(){
        Assert.assertEquals(3,Team.getPrimeNumberClosesTo(3));
    }

    @Test
    public void test_2(){
        Assert.assertEquals(7,Team.getPrimeNumberClosesTo(8));
    }

    @Test
    public void test_3() {
        int result = Team.getPrimeNumberClosesTo(9);
//        if (result == 7 || result == 11) {
//            assertTrue(true);
//        } else {
//            fail("Returned " + result + " expected 7 or 11");
//        }

        assertTrue(result == 7 || result == 11, "Returned " + result + " expected 7 or 11");
    }

    @Test
    public void test_getHelloWorldText(){
        String result = Team.getHelloWorldText();
        if("Good morning world!".equals(result) || "Good day world!".equals(result) || "Hello world!".equals(result) || "Good night world!".equals(result)){
            assertTrue(true);
        }
        else {
            fail("Result did not contain expected string. Actual: " + result);
        }
    }

    @Test
    public void test_getHelloWorldText2(){
        String result = Team.getHelloWorldText();
        assertTrue(result.contains("world"), "Expected result to contain world");
    }


}
