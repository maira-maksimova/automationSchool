package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.NoSuchElementException;

public class VacancyDetails extends BasePage{
    private WebDriver driver;
    private static final By VACANCY_TITLE = By.cssSelector(".active h1");
    private static final By VACANCY_DETAILS = By.cssSelector(".vacancies-second-contents.active p");


    public VacancyDetails(WebDriver driver) {
        this.driver = driver;
        super.waitForElementToBeDisplayed(driver, VACANCY_TITLE);

    }

    public String getVacancyRequiredSkills() {
        List<WebElement> requirements = driver.findElements(VACANCY_DETAILS);

        String requiredSkills = new String();

        for (int i = 0; i < requirements.size(); i++) {
            if (requirements.get(i).getText().contains("Professional skills and qualification:") && i < requirements.size()-1) {

                requiredSkills = requirements.get(i + 1).getText();
                break;
            }
        }
        if(requiredSkills.isEmpty()){
            throw new NoSuchElementException("Required skills not found");
        }
        return requiredSkills;
    }
}
