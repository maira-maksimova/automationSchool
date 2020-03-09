
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;

import org.assertj.core.api.SoftAssertions;
import pages.CtcoSidebar;

public class TestVerifyTestAutomationEngineerVacancyTest extends TestSetup {
    private WebDriver driver;
    private SoftAssertions assertions = new SoftAssertions();


    @BeforeEach
    public void setUp() {
        super.setUp();
        this.driver = super.driver;
    }

    @AfterEach
    public void tearDown() {
        super.tearDown();
    }

    @Test
    public void testVerifyTestAutomationEngineerVacancy() throws Exception {

        String requiredSkills = new CtcoSidebar(driver)
                .hoverCareersMenu()
                .clickVacancies()
                .clickOnVacancy("Test Automation Engineer")
                .getVacancyRequiredSkills();

        assertions.assertThat(requiredSkills).contains("Selenium");
        assertions.assertThat(requiredSkills).contains("communication skills");
        assertions.assertThat(requiredSkills).contains("Good level in English");
        assertions.assertAll();
    }
}
