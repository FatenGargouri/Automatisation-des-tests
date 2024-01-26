package test_selenium_testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestPageJmeter {

    WebDriver driver;

    @BeforeTest
    public void configuration() {
        // Initialiser le WebDriver
        driver = new ChromeDriver();
        // Naviguer vers le site web Automation Step by Step.
        driver.get("https://automationstepbystep.com/");
        // Attendre que la page soit chargée.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.titleContains("Automation Step by Step"));
    }

    @Test
    public void testerPageJmeter() throws InterruptedException {
        // Cliquer sur l'élément dans la page JMeter.
        driver.findElement(By.id("menu-item-86")).click();
        // Attendre que la page soit chargée.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.titleContains("JMeter"));

        // Tester le champ de recherche.
        WebElement champRecherche = driver.findElement(By.name("s"));
        champRecherche.sendKeys("docker", Keys.ENTER);
        // Attendre que les résultats de la recherche soient chargés.
        wait.until(ExpectedConditions.titleContains("docker"));
        // Attendre 4 secondes avant de fermer.
        Thread.sleep(4000);

        // Tester les liens de la page JMeter.
        driver.navigate().back();
        Thread.sleep(1000);

        driver.findElement(By.cssSelector("#pageid-85 > div > div.entry > p > a:nth-child(1)")).click();
        Thread.sleep(1000);

        driver.navigate().back();
        Thread.sleep(1000);
    }

    @AfterTest
    public void fermerNavigateur() {
        // Fermer le driver.
        if (driver != null) {
            driver.quit();
        }
    }
}
