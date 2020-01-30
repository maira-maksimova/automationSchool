package com.ctco.testSchool.tests;

import com.ctco.testSchool.Member;
import com.ctco.testSchool.Story;
import com.ctco.testSchool.Team;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.ctco.testSchool.Member.type.DEV;
import static com.ctco.testSchool.Member.type.TEST;

public class CanDeliverQualityWhiteBoxTest {

    @Test
    public void canDeliverQualityWBHappyPath(){
        Team myTeam = new Team();
        Member developer1 = new Member(DEV);
        Member developer2 = new Member(DEV);
        Member tester = new Member(TEST);

        myTeam.addMember(developer1);
        myTeam.addMember(developer2);
        myTeam.addMember(tester);

        Story story1 = new Story();
        story1.setStoryPoints(5);
        story1.setTestPoints(2);

        Story story2 = new Story();
        story2.setStoryPoints(8);
        story2.setTestPoints(2);

        Story story3 = new Story();
        story3.setStoryPoints(5);
        story3.setTestPoints(3);

        Story story4 = new Story();
        story4.setStoryPoints(5);
        story4.setTestPoints(3);

        List<Story> stories = new ArrayList<Story>();
        stories.add(story1);
        stories.add(story2);
        stories.add(story3);
        stories.add(story4);

        myTeam.backlog = stories;

        Assert.assertTrue(myTeam.canDeliverQuality());
    }

    @Test
    public void canDeliverQualityWBTooMuchStoryPoints(){
        Team myTeam = new Team();
        Member developer1 = new Member(DEV);
        Member developer2 = new Member(DEV);
        Member tester = new Member(TEST);

        myTeam.addMember(developer1);
        myTeam.addMember(developer2);
        myTeam.addMember(tester);

        Story story1 = new Story();
        story1.setStoryPoints(13);
        story1.setTestPoints(2);

        Story story2 = new Story();
        story2.setStoryPoints(8);
        story2.setTestPoints(2);

        Story story3 = new Story();
        story3.setStoryPoints(5);
        story3.setTestPoints(3);

        Story story4 = new Story();
        story4.setStoryPoints(5);
        story4.setTestPoints(3);

        List<Story> stories = new ArrayList<Story>();
        stories.add(story1);
        stories.add(story2);
        stories.add(story3);
        stories.add(story4);

        myTeam.backlog = stories;

        Assert.assertTrue(myTeam.canDeliverQuality());
    }

    @Test
    public void canDeliverQualityWBNoDevelopers(){
        Team myTeam = new Team();
        Member tester = new Member(TEST);

        myTeam.addMember(tester);

        Story story1 = new Story();
        story1.setStoryPoints(8);
        story1.setTestPoints(5);

        List<Story> stories = new ArrayList<Story>();
        stories.add(story1);

        myTeam.backlog = stories;

        Assert.assertTrue(myTeam.canDeliverQuality());
    }

    @Test
    public void canDeliverQualityWBTestingCannotFitIntoSprint() {
        Team myTeam = new Team();
        Member developer1 = new Member(DEV);
        Member developer2 = new Member(DEV);
        Member tester = new Member(TEST);

        myTeam.addMember(developer1);
        myTeam.addMember(developer2);
        myTeam.addMember(tester);

        Story story1 = new Story();
        story1.setStoryPoints(8);
        story1.setTestPoints(5);

        Story story2 = new Story();
        story2.setStoryPoints(3);
        story2.setTestPoints(3);

        List<Story> stories = new ArrayList<Story>();
        stories.add(story1);
        stories.add(story2);

        myTeam.backlog = stories;

        Assert.assertTrue(myTeam.canDeliverQuality());
    }

    @Test
    public void canDeliverQualityWBTooMuchTestingPoints() {
        Team myTeam = new Team();
        Member developer1 = new Member(DEV);
        Member developer2 = new Member(DEV);
        Member tester = new Member(TEST);
        tester.velocity = 0.8;

        myTeam.addMember(developer1);
        myTeam.addMember(developer2);
        myTeam.addMember(tester);

        Story story1 = new Story();
        story1.setStoryPoints(2);
        story1.setTestPoints(5);

        Story story2 = new Story();
        story2.setStoryPoints(3);
        story2.setTestPoints(5);

        List<Story> stories = new ArrayList<Story>();
        stories.add(story1);
        stories.add(story2);

        myTeam.backlog = stories;

        Assert.assertFalse(myTeam.canDeliverQuality());
    }

    @Test
    public void canDeliverQualityWBEmptyBacklog() { //Null pointer exception
        Team myTeam = new Team();
        Member developer1 = new Member(DEV);
        Member developer2 = new Member(DEV);
        Member tester = new Member(TEST);
        tester.velocity = 0.8;

        myTeam.addMember(developer1);
        myTeam.addMember(developer2);
        myTeam.addMember(tester);

        Assert.assertTrue(myTeam.canDeliverQuality());
    }

    @Test
    public void canDeliverQualityWBNoTeamMembers() {
        Team myTeam = new Team();

        Story story1 = new Story();
        story1.setStoryPoints(2);
        story1.setTestPoints(5);

        Story story2 = new Story();
        story2.setStoryPoints(3);
        story2.setTestPoints(5);

        List<Story> stories = new ArrayList<Story>();
        stories.add(story1);
        stories.add(story2);

        myTeam.backlog = stories;

        Assert.assertFalse(myTeam.canDeliverQuality());
    }

    @Test
    public void canDeliverQualityWBZeroSprintDays() {
        Team myTeam = new Team();
        Member developer1 = new Member(DEV);
        Member developer2 = new Member(DEV);
        Member tester = new Member(TEST);
        tester.velocity = 0.8;

        myTeam.sprintDays = 0;

        myTeam.addMember(developer1);
        myTeam.addMember(developer2);
        myTeam.addMember(tester);

        Story story1 = new Story();
        story1.setStoryPoints(2);
        story1.setTestPoints(1);

        Story story2 = new Story();
        story2.setStoryPoints(3);
        story2.setTestPoints(5);

        List<Story> stories = new ArrayList<Story>();
        stories.add(story1);
        stories.add(story2);

        myTeam.backlog = stories;

        Assert.assertFalse(myTeam.canDeliverQuality());
    }

    @Test
    public void canDeliverQualityWBZeroTestingPoints() {
        Team myTeam = new Team();
        Member developer1 = new Member(DEV);
        Member developer2 = new Member(DEV);
        Member tester = new Member(TEST);
        tester.velocity = 0.8;

        myTeam.addMember(developer1);
        myTeam.addMember(developer2);
        myTeam.addMember(tester);

        Story story1 = new Story();
        story1.setStoryPoints(2);
        story1.setTestPoints(0);

        List<Story> stories = new ArrayList<Story>();
        stories.add(story1);

        myTeam.backlog = stories;

        Assert.assertTrue(myTeam.canDeliverQuality());
    }

    @Test
    public void canDeliverQualityWBNoTestingPoints() {
        Team myTeam = new Team();
        Member developer1 = new Member(DEV);
        Member developer2 = new Member(DEV);
        Member tester = new Member(TEST);
        tester.velocity = 0.8;

        myTeam.addMember(developer1);
        myTeam.addMember(developer2);
        myTeam.addMember(tester);

        Story story1 = new Story();
        story1.setStoryPoints(2);

        List<Story> stories = new ArrayList<Story>();
        stories.add(story1);

        myTeam.backlog = stories;

        Assert.assertTrue(myTeam.canDeliverQuality());
    }

    @Test
    public void canDeliverQualityWBZeroTesterVelocity(){
        Team myTeam = new Team();
        Member developer1 = new Member(DEV);
        Member tester = new Member(TEST);
        tester.velocity = 0;

        myTeam.addMember(developer1);
        myTeam.addMember(tester);

        Story story1 = new Story();
        story1.setStoryPoints(3);
        story1.setTestPoints(1);

        List<Story> stories = new ArrayList<Story>();
        stories.add(story1);

        myTeam.backlog = stories;

        Assert.assertFalse(myTeam.canDeliverQuality());
    }
}
