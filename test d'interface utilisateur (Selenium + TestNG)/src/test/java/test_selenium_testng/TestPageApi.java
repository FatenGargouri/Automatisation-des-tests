package test_selenium_testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestPageApi {

    WebDriver driver;

    @BeforeTest
    public void configuration() {
        // Initialiser le WebDriver
        driver = new ChromeDriver();
    }

    @Test
    public void testerPageApi() throws InterruptedException {
        // Naviguer vers le site web Automation Step by Step.
        driver.get("https://automationstepbystep.com/");
        Thread.sleep(2000);

        // Attendre que la page soit chargée.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.titleContains("Automation Step by Step"));

        // Tester la barre de menu pour aller à la page API.
        WebElement api = driver.findElement(By.id("menu-item-136"));
        api.click();
        wait.until(ExpectedConditions.titleContains("API"));

        // Tester le sélecteur de catégorie.
        driver.findElement(By.name("cat")).click();
        driver.findElement(By.xpath("//*[@id=\"cat\"]/option[18]")).click();
        Thread.sleep(2000);

        // Revenir à la page API.
        driver.navigate().back();
        Thread.sleep(2000);

        // Tester la modification des langues.
        driver.findElement(By.xpath("//*[@id=\":0.targetLanguage\"]/span/a")).click();
        driver.switchTo().frame(3);
        driver.findElement(By.cssSelector("td:nth-child(1) > .VIpgJd-ZVi9od-vH1Gmf-ibnC6b:nth-child(7) .text")).click();
        Thread.sleep(3000);
    }

    @AfterTest
    public void fermerNavigateur() {
        // Fermer le driver.
        if (driver != null) {
            driver.quit();
        }
    }
}
