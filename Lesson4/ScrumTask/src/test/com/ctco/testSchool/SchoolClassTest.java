package com.ctco.testSchool;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class SchoolClassTest {

    @Test
    public void createRobot() throws  Exception{
        Robot robot = new Robot(2,2);
    }

    @Test
    public void createMoonWithRobot() throws Exception{
        Moon moon = new Moon(10,10);
        Robot robot = new Robot(2,2);
        moon.setRobot(robot);
        Assert.assertEquals(2, moon.getRobot().getX());
        Assert.assertEquals(2, moon.getRobot().getY());
    }

    @Test
    public void moveRobot() throws Exception{
        Moon moon = new Moon(10,10);
        Robot robot = new Robot(2,5);
        moon.setRobot(robot);
        Assert.assertEquals(2, moon.getRobot().getX());
        Assert.assertEquals(5, moon.getRobot().getY());
        moon.getRobot().moveX(1);
        moon.getRobot().moveY(10);
        Assert.assertEquals(3, moon.getRobot().getX());
        Assert.assertEquals(15, moon.getRobot().getY());

    }

    @Test
    public void negaviveMove() throws Exception{
        Moon moon = new Moon(10, 10);
        Robot robot = new Robot(1, 5);

        try {
            robot.moveX(-2);
            fail("Expected to fail as resulting X canot be negative");

        } catch (Exception e){
            Assert.assertEquals("Robot cannot go outside", e.getMessage());
        }
    }

    @Test
    public void testAddRobotToNegativeCoordinates() throws Exception{

        try {
            new Robot(-1,-4);
            fail("Expected to fail robot could not be added with negative coordinates");
        } catch(Exception e) {
            Assert.assertEquals("Robot cannot has negative coordinates", e.getMessage());
        }
    }

    @Test
    public void testAddRobotOutOfMoon() throws Exception{
        Robot robot = new Robot(1,22);
        Moon moon = new Moon(10,10);
        try {
           moon.setRobot(robot);
            fail("Expected to fail robot could not be added with negative coordinates");
        } catch(Exception e) {
            Assert.assertEquals("Robot cannot has negative coordinates", e.getMessage());
        }
    }

    @Test
    public  void testRobotOutsideMoon() throws Exception{
        Robot robot = new Robot(0,0);
        Moon moon = new Moon(10,10);
        moon.setRobot(robot);

        robot.moveX(5);
        Assert.assertEquals(5, robot.getX());

        try {
            robot.moveX(6);
            fail("Expected to fail as Robot cannot go outside Moon by X axes");
        } catch(Exception e) {
            Assert.assertEquals("Robot cannot go out of Moon", e.getMessage());
        }
    }

//    @Test
//    public void cantMoveWithoutMove(){
//
//        Robot robot = new Robot(2,2);
//
//        robot.moveX(1);
//
//    }



}
