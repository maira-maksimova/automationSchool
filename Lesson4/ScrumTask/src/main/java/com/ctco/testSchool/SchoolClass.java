package com.ctco.testSchool;

public class SchoolClass {
}

class Robot {

    int x;
    int y;
    Moon myMoon;
    String Name;

    public Robot(int x, int y) throws  Exception{
        if(x < 0 || y < 0){
            throw new Exception("Robot cannot has negative coordinates");
        }

        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public  void moveX(int x) throws Exception{

        if(this.x + x > myMoon.width) {
            throw new Exception("Robot cannot go out of Moon");
        }

        if(this.x + x < 0) {
            throw new Exception("Robot cannot go outside");
        }
        else {
            this.x += x;
        }
    }

    public  void moveY(int y){
        this.y += y;

    }
}

class  Moon {
    int width;
    int height;
    private Robot robot;

    public Robot getRobot() {
        return robot;
    }

    public void setRobot(Robot robot)throws Exception {
        if(robot.x > this.width || robot.y > this.height){
            throw new Exception("Robot cannot has negative coordinates");
        }
        this.robot = robot;
        robot.myMoon = this;
    }

    public Moon(int width, int height) {
        this.width = width;
        this.height = height;
    }



}