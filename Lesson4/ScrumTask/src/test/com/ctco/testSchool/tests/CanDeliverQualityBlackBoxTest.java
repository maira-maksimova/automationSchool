package com.ctco.testSchool.tests;

import com.ctco.testSchool.Member;
import com.ctco.testSchool.Story;
import com.ctco.testSchool.Team;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.ctco.testSchool.Member.type.DEV;
import static com.ctco.testSchool.Member.type.TEST;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class CanDeliverQualityBlackBoxTest {
    Team myTeam;
    Member developer1;
    Member developer2;
    Member tester;

    List<Story> stories;

    Story story1;
    Story story2;
    Story story3;
    Story story4;

    @BeforeEach
    public void before(){
        myTeam = new Team();
        developer1 = new Member(DEV);
        developer2 = new Member(DEV);
        tester = new Member(TEST);

        stories = new ArrayList<Story>();

        story1 = new Story();
        story2 = new Story();
        story3 = new Story();
        story4 = new Story();
    }

    @Test
    public void canDeliverQualityHappyPath() {

        myTeam.addMember(developer1);
        myTeam.addMember(developer2);
        myTeam.addMember(tester);

        story1.setStoryPoints(5);
        story1.setTestPoints(2);

        story2.setStoryPoints(5);
        story2.setTestPoints(2);

        story3.setStoryPoints(5);
        story3.setTestPoints(3);

        story4.setStoryPoints(5);
        story4.setTestPoints(3);


        stories.add(story1);
        stories.add(story2);
        stories.add(story3);
        stories.add(story4);

        myTeam.backlog = stories;

        Assert.assertTrue(myTeam.canDeliverQuality());

        myTeam.sprintDays = 9;
        Assert.assertFalse(myTeam.canDeliverQuality());
    }

    @Test
    public void canDeliverQualityTooMuchTestingPoints() {
        myTeam.addMember(developer1);
        myTeam.addMember(developer2);
        myTeam.addMember(tester);

        story1.setStoryPoints(5);
        story1.setTestPoints(3);

        story2.setStoryPoints(8);
        story2.setTestPoints(8);

        stories.add(story1);
        stories.add(story2);

        myTeam.backlog = stories;

        Assert.assertFalse("Quality cannot be delivered because testing points are larger than tester capacity", myTeam.canDeliverQuality());
    }

    @Test
    public void canDeliverQualityTooMuchStoryPoints() {
        myTeam.addMember(developer1);
        myTeam.addMember(developer2);
        myTeam.addMember(tester);

        story1.setStoryPoints(13);
        story1.setTestPoints(3);

        story2.setStoryPoints(8);
        story2.setTestPoints(3);

        stories.add(story1);
        stories.add(story2);

        myTeam.backlog = stories;

        Assert.assertFalse("Quality cannot be delivered because story points are larger than developers capacity", myTeam.canDeliverQuality());
    }

    @Test
    public void canDeliverQualityTestingCannotFitIntoSprint() {

        myTeam.addMember(developer1);
        myTeam.addMember(developer2);
        myTeam.addMember(tester);

        story1.setStoryPoints(8);
        story1.setTestPoints(5);

        story2.setStoryPoints(3);
        story2.setTestPoints(3);

        stories.add(story1);
        stories.add(story2);

        myTeam.backlog = stories;

        Assert.assertFalse("Quality cannot be delivered because 1 tested cannot test both stories during sprint because of timeline", myTeam.canDeliverQuality());
    }

    @Test
    public void canDeliverQualityNoDevelopers(){

        myTeam.addMember(tester);

        story1.setStoryPoints(8);
        story1.setTestPoints(5);

        stories.add(story1);

        myTeam.backlog = stories;

        Assert.assertFalse("Quality cannot be delivered because team has no developers to implement story", myTeam.canDeliverQuality());
    }

    @Test
    public void canDeliverQualityNoTesters(){

        myTeam.addMember(developer1);

        story1.setStoryPoints(1);
        story1.setTestPoints(1);

        stories.add(story1);

        myTeam.backlog = stories;

        Assert.assertFalse("Quality cannot be delivered because team has no testers",myTeam.canDeliverQuality());
    }

    @Test
    public void canDeliverQualityOnlyTestingPoints(){

        myTeam.addMember(tester);

        story1.setStoryPoints(0);
        story1.setTestPoints(5);

        story2.setStoryPoints(0);
        story2.setTestPoints(5);

        stories.add(story1);
        stories.add(story2);

        myTeam.backlog = stories;

        Assert.assertTrue("Quality can be delivered without developers if stories has only testing points", myTeam.canDeliverQuality());
    }

    @Test
    public void canDeliverQualityNoTestingRequired(){

        myTeam.addMember(developer1);
        myTeam.addMember(tester);

        story1.setStoryPoints(3);
        story1.setTestPoints(0);

        stories.add(story1);

        myTeam.backlog = stories;

        Assert.assertTrue("Quality can be delivered if testing not required for story", myTeam.canDeliverQuality());
    }

    @Test
    public void canDeliverQualityZeroTesterVelocity(){
        tester.velocity = 0;

        myTeam.addMember(developer1);
        myTeam.addMember(tester);

        story1.setStoryPoints(3);
        story1.setTestPoints(1);

        stories.add(story1);

        myTeam.backlog = stories;

        try {
            myTeam.canDeliverQuality();
            fail("Expected to fail with 0 tester velocity");

        } catch(IllegalArgumentException e){
            assertEquals("Velocity should be positive", e.getMessage());
        }
    }

    @Test
    public void canDeliverQualityZeroDeveloperVelocity(){
        developer1.velocity = 0;

        myTeam.addMember(developer1);
        myTeam.addMember(tester);

        story1.setStoryPoints(3);
        story1.setTestPoints(1);

        stories.add(story1);

        myTeam.backlog = stories;

        try {
            myTeam.canDeliverQuality();
            fail("Expected to fail with 0 developer velocity");

        } catch(IllegalArgumentException e){
            assertEquals("Velocity should be positive", e.getMessage());
        }
    }

    @Test
    public void canDeliverQualityZeroSprintDays() {

        myTeam.sprintDays = 0;

        stories.add(story1);

        myTeam.backlog = stories;

        try {
            myTeam.canDeliverQuality();
            fail("Expected to fail with 0 story points");

        }catch (IllegalArgumentException e){
            assertEquals("Sprint should be at least two days long", e.getMessage());
        }
    }

    @Test
    public void canDeliverQualityNoTeamMembers() {
        story1.setStoryPoints(2);
        story1.setTestPoints(5);

        story2.setStoryPoints(3);
        story2.setTestPoints(5);

        stories.add(story1);
        stories.add(story2);

        myTeam.backlog = stories;

        Assert.assertFalse("Quality cannot be delivered without developers and testers", myTeam.canDeliverQuality());
    }

    @Test
    public void canDeliverQualityTestingCannotBeDone() { //2 stories each with 5 story points and 5 testing points, 1 developer and 1 tester
        myTeam.addMember(developer1);
        myTeam.addMember(tester);

        story1.setStoryPoints(5);
        story1.setTestPoints(5);

        story2.setStoryPoints(5);
        story2.setTestPoints(5);

        stories.add(story1);
        stories.add(story2);

        myTeam.backlog = stories;

        Assert.assertFalse(myTeam.canDeliverQuality());
    }

    @Test
    public void canDeliverQualityIncreasedVelocity() {
        myTeam.addMember(developer1);
        developer1.velocity = 2;

        myTeam.backlog = stories;

        try {
            myTeam.canDeliverQuality();
            fail("Expected to fail with velocity larger than 1");

        }catch (IllegalArgumentException e){
            assertEquals("Velocity can't be more than 1", e.getMessage());
        }
    }


    //velocity 0.99

    //1+1, 7+1 1 dev 1 tester

    //3 developers, 4 stories with 6 story points False

}
