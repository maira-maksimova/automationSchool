package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CtcoPage {

    WebDriver driver;

    public By careerMenuLocator = By.xpath("//a[text()='Careers']");
    public By carrerSubMenuLocator = By.xpath("//a[text()=\"Careers\"]/../ul[@class=\"sub-menu\"]");
    public By vacanciesLinkLocator = By.xpath("//a[text()=\"Vacancies\"]");
    public By vacanciesListLocator = By.cssSelector(".vacancies-menu-block");
    public By testEngineerLinkLocator = By.linkText("Test Automation Engineer");
    public By vacancyTitleLocator = By.cssSelector(".active h1");
    public By requiredSkillsLocator = By.xpath("//div[contains(@class,'active')]//*[contains(text(),'Professional skills and qualification')]/../../following-sibling::p[1]");

    public CtcoPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://ctco.lv/");
    }

    public WebElement getCareerMenu() {
        return driver.findElement(careerMenuLocator);
    }

    public WebElement getCareerSubMenu() {
        return driver.findElement(carrerSubMenuLocator);
    }

    public WebElement getVacanciesLink() {
        return driver.findElement(vacanciesLinkLocator);
    }

    public WebElement getVacanciesList() {
        return driver.findElement(vacanciesListLocator);
    }

    public WebElement getTestEngineerLink() {
        return driver.findElement(testEngineerLinkLocator);
    }
    public WebElement getVacancyTitle() {
        return driver.findElement(vacancyTitleLocator);
    }

    public WebElement getRequiredSkills() {
        return driver.findElement(requiredSkillsLocator);
    }

}
