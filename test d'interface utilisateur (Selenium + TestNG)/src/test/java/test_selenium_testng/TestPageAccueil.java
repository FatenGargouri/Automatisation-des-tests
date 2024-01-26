package test_selenium_testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestPageAccueil {

    WebDriver driver;

    @BeforeTest
    public void configuration() {
        // Initialiser le WebDriver
        driver = new ChromeDriver();
    }

    @Test
    public void testerPageAcceuil() throws InterruptedException {
        // Naviguer vers le site web Automation Step by Step.
        driver.get("https://automationstepbystep.com/");
        Thread.sleep(2000);

        // Attendre que la page soit chargée.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.titleContains("Automation Step by Step"));

        // Tester la barre de menu.
        WebElement casJmeter = driver.findElement(By.id("menu-item-86"));
        WebElement jmeterDebutant = driver.findElement(By.id("menu-item-113"));
        WebElement jmeterIntermediaire = driver.findElement(By.id("menu-item-116"));
        WebElement jmeterAvance = driver.findElement(By.id("menu-item-119"));

        // Utiliser les actions.
        Actions action = new Actions(driver);
        action.moveToElement(casJmeter).perform();
        Thread.sleep(2000);

        // Attendre que le sous-menu soit visible.
        wait.until(ExpectedConditions.visibilityOf(jmeterDebutant));
        wait.until(ExpectedConditions.visibilityOf(jmeterIntermediaire));
        wait.until(ExpectedConditions.visibilityOf(jmeterAvance));

        // Attendre 3 secondes avant de fermer.
        Thread.sleep(2000);

        // Tester le lien vers JMeter.
        driver.findElement(By.id("menu-item-86")).click();
        Thread.sleep(3000);
        // Revenir à la page précédente.
        driver.navigate().back();
        Thread.sleep(1000);

        // Tester le lien vers la page "About".
        driver.findElement(By.id("menu-item-4595")).click();
        Thread.sleep(2000);
    }

    @AfterTest
    public void fermerNavigateur() {
        // Fermer le driver.
        if (driver != null) {
            driver.quit();
        }
    }
}
