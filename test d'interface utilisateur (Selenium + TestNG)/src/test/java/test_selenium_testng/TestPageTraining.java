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

public class TestPageTraining {

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
    public void testerPageTraining() throws InterruptedException {
        // Cliquer sur l'élément dans la page Training.
        driver.findElement(By.id("menu-item-1476")).click();
        // Attendre que la page soit chargée.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.titleContains("Training"));

        // Rechercher le cours dans le tableau.
        WebElement barreRecherche = driver.findElement(By.xpath("//*[@id=\"tablepress-2_filter\"]/label/input"));
        barreRecherche.click();
        barreRecherche.sendKeys("Jmeter", Keys.ENTER);
        Thread.sleep(2000);

        // Tester la taille du tableau.
        driver.findElement(By.name("tablepress-2_length")).click();
        WebElement taille = driver.findElement(By.xpath("//*[@id=\"tablepress-2_length\"]/label/select/option[1]"));
        taille.click();
        Thread.sleep(2000);

        // Tester les liens du tableau.
        WebElement colonne = driver.findElement(By.xpath("//*[@id=\"tablepress-2\"]/tbody/tr[4]/td[1]/a"));
        colonne.click();
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
