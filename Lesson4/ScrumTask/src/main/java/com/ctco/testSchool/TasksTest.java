package com.ctco.testSchool;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class TasksTest {

    //FirstTask tests
    @Test
    public void concatenateHappyPath(){
        Assert.assertEquals("5text", FirstTask.concatenate(1,3,"text"));
    }

    @Test
    public void concatenateZeroAndNumberAsString(){
        Assert.assertEquals("19", FirstTask.concatenate(0,0,"9"));
    }

    @Test
    public void concatenateNegativeNumberEmptyString(){
        Assert.assertEquals("0", FirstTask.concatenate(0,-1,""));
    }

    //SecondTask tests
    @Test
    public void isEvenHappyPath(){
        SecondTask secondTask = new SecondTask();
        Assert.assertTrue(secondTask.isEven(2));
    }

    @Test
    public void isEvenNegative(){
        SecondTask secondTask = new SecondTask();
        Assert.assertFalse(secondTask.isEven(3));
    }

    @Test
    public void isEvenZero(){
        SecondTask secondTask = new SecondTask();
        Assert.assertTrue(secondTask.isEven(2));
    }


    //ThirdTask tests
    @Test
    public void getElementPositionHappyPathFirst(){
        ThirdTask thirdTask = new ThirdTask();
        String[] array = { "one", "two","three"};
        Assert.assertEquals(0, thirdTask.getElementPosition(array, "one"));
    }

    @Test
    public void getElementPositionNegativeStringNotPresent(){
        ThirdTask thirdTask = new ThirdTask();
        String[] array = { "one", "two","three"};
        Assert.assertEquals(-1, thirdTask.getElementPosition(array, "four"));
    }

    @Test
    public void getElementPositionLast(){
        ThirdTask thirdTask = new ThirdTask();
        String[] array = { "one", "two","three"};
        Assert.assertEquals(2, thirdTask.getElementPosition(array, "three"));
    }

    //FourthTask Tests
    @Test
    public void getPerimeterHappyPath(){
        FourthTask fourthTask = new FourthTask(2,4);
        Assert.assertEquals(12, fourthTask.getPerimeter(), 0.001d);
    }

    @Test
    public void getPerimeterZeros(){
        FourthTask fourthTask = new FourthTask(0,0);
        Assert.assertEquals(0, fourthTask.getPerimeter(), 0.001d);
    }

    @Test
    public void getPerimeterEquals(){
        FourthTask fourthTask = new FourthTask(5,5);
        Assert.assertEquals(20, fourthTask.getPerimeter(), 0.001d);
    }

    // FifthTask Tests
    @Test
    public void isRectangleHappyPath(){
        FourthTask fourthTask = new FourthTask(5,5);
        FifthTask fifthTask = new FifthTask();
        Assert.assertEquals("true",fifthTask.isRectangle(fourthTask));
    }

    @Test
    public void isRectangleZero(){
        FourthTask fourthTask = new FourthTask(0,2);
        FifthTask fifthTask = new FifthTask();
        Assert.assertEquals("false",fifthTask.isRectangle(fourthTask));
    }

    @Test
    public void isRectangleNegative(){
        FourthTask fourthTask = new FourthTask(-3,4);
        FifthTask fifthTask = new FifthTask();
        Assert.assertEquals("false",fifthTask.isRectangle(fourthTask));
    }

    //SixthTask tests
    @Test
    public void isNumberPositiveHappyPath(){
        Assert.assertEquals("positive", SixthTask.isNumberPositive(5));
    }

    @Test
    public void isNumberPositiveNegative(){
        Assert.assertEquals("negative", SixthTask.isNumberPositive(-1));
    }

    @Test
    public void isNumberPositiveZero(){
        Assert.assertEquals("positive", SixthTask.isNumberPositive(0));
    }

    //SeventhTask Test
    @Test
    public void getDogBread(){
        SeventhTask.Dog dog = new SeventhTask.Dog("Mailo");
        dog.breed = "Laika";

        Assert.assertEquals("Laika", SeventhTask.getDogBreed(dog));
    }

    //EightTask Tests
    @Test
    public void addStringsToList(){
        EightTask eightTask = new EightTask();
        List<String> list = eightTask.addStringsToList("one", "m", "c");
        Assert.assertEquals(["one", "m", "c"], list);
    }


}
