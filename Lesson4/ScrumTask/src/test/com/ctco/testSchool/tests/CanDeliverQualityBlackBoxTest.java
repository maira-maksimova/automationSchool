package com.ctco.testSchool.tests;

import com.ctco.testSchool.Member;
import com.ctco.testSchool.Story;
import com.ctco.testSchool.Team;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import java.util.ArrayList;
import java.util.List;

import static com.ctco.testSchool.Member.type.DEV;
import static com.ctco.testSchool.Member.type.TEST;

public class CanDeliverQualityBlackBoxTest {

    @Test
    public void canDeliverQualityHappyPath() {
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
    public void canDeliverQualityTooMuchTestingPoints() {
        Team myTeam = new Team();
        Member developer1 = new Member(DEV);
        Member developer2 = new Member(DEV);
        Member tester = new Member(TEST);

        myTeam.addMember(developer1);
        myTeam.addMember(developer2);
        myTeam.addMember(tester);

        Story story1 = new Story();
        story1.setStoryPoints(5);
        story1.setTestPoints(3);

        Story story2 = new Story();
        story2.setStoryPoints(8);
        story2.setTestPoints(8);

        List<Story> stories = new ArrayList<Story>();
        stories.add(story1);
        stories.add(story2);

        myTeam.backlog = stories;

        Assert.assertFalse(myTeam.canDeliverQuality());
    }

    @Test
    public void canDeliverQualityTooMuchStoryPoints() {
        Team myTeam = new Team();
        Member developer1 = new Member(DEV);
        Member developer2 = new Member(DEV);
        Member tester = new Member(TEST);

        myTeam.addMember(developer1);
        myTeam.addMember(developer2);
        myTeam.addMember(tester);

        Story story1 = new Story();
        story1.setStoryPoints(13);
        story1.setTestPoints(3);

        Story story2 = new Story();
        story2.setStoryPoints(8);
        story2.setTestPoints(3);

        List<Story> stories = new ArrayList<Story>();
        stories.add(story1);
        stories.add(story2);

        myTeam.backlog = stories;

        Assert.assertFalse(myTeam.canDeliverQuality());
    }

    @Test
    public void canDeliverQualityTestingCannotFitIntoSprint() {
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

        Assert.assertFalse(myTeam.canDeliverQuality());
    }
}
