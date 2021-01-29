package test;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ParabankSmokeTest {

    @Test
    public void registerTestCase(){
        // --- Test Data
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String streetAddr = faker.address().streetAddress();
        String cityVal = faker.address().city();
        String stateVal = faker.address().state();
        String zipCodeVal = faker.address().zipCode();
        String phoneNumVal = faker.phoneNumber().cellPhone();
        String ssnVal = faker.idNumber().ssnValid();
        String usernameVal = faker.name().username();
        String passwordVal = faker.internet().password();
        String expectedMessage = "Your account was created successfully.";

        // --- Test Steps
        WebDriverManager.chromedriver().setup(); // downlaod
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        By register_link = By.linkText("Register");
        WebElement registerLink = driver.findElement(register_link);
        registerLink.click();

        By first_name = By.id("customer.firstName");
        WebElement firstNameInput = driver.findElement(first_name);
        firstNameInput.sendKeys(firstName);

        driver.quit();
    }

    @Test
    public void transferTestCase(){

    }
}
