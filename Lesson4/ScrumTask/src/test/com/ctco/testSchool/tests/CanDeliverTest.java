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

public class CanDeliverTest {
    Team myTeam = new Team();

    //Story points 18, 2 developers (velocity 20) should be true but test fails
    @Test
    public void happyPathCanDeliverTest(){

        Member developer1 = new Member(DEV);
        Member developer2 = new Member(DEV);
        Member tester = new Member(TEST);

        myTeam.addMember(developer1);
        myTeam.addMember(developer2);
        myTeam.addMember(tester);

        Story story1 = new Story();
        story1.setStoryPoints(5);

        Story story2 = new Story();
        story2.setStoryPoints(8);

        Story story3 = new Story();
        story3.setStoryPoints(3);

        Story story4 = new Story();
        story4.setStoryPoints(2);

        List<Story> stories = new ArrayList<Story>();
        stories.add(story1);
        stories.add(story2);
        stories.add(story3);
        stories.add(story4);

        myTeam.backlog = stories;

        Assert.assertTrue(myTeam.canDeliver());
    }

    @Test
    public void negativeCanDeliverTest(){
        Member developer1 = new Member(DEV);
        Member developer2 = new Member(DEV);
        Member tester = new Member(TEST);

        myTeam.addMember(developer1);
        myTeam.addMember(developer2);
        myTeam.addMember(tester);

        Story story1 = new Story();
        story1.setStoryPoints(8);

        Story story2 = new Story();
        story2.setStoryPoints(8);

        Story story3 = new Story();
        story3.setStoryPoints(3);

        Story story4 = new Story();
        story4.setStoryPoints(2);

        List<Story> stories = new ArrayList<Story>();
        stories.add(story1);
        stories.add(story2);
        stories.add(story3);
        stories.add(story4);

        myTeam.backlog = stories;

        Assert.assertFalse(myTeam.canDeliver());
    }
}
