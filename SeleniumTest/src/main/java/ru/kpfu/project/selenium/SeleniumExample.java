package ru.kpfu.project.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by unlim_000 on 12.06.2016.
 */
public class SeleniumExample {

    public boolean testLogin(WebDriver driver) {
        driver.get("http://localhost:8080");
        WebElement element = driver.findElement(By.linkText("Логин"));
        element.click();
        driver.get(driver.getCurrentUrl());

        WebElement loginInput = driver.findElement(By.name("j_username"));
        WebElement passInput = driver.findElement(By.name("j_password"));
        loginInput.sendKeys("unlimited");
        passInput.sendKeys("12345");
        passInput.submit();


        driver.get("http://localhost:8080");
        if (driver.findElement(By.linkText("unlimited")) != null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean testComment(WebDriver driver){
        this.testLogin(driver);
        driver.findElement(By.linkText("Новости")).click();
        driver.get(driver.getCurrentUrl());
        driver.findElement(By.linkText("Невезучий Гертль и победа Питтсбурга!")).click();
        driver.get(driver.getCurrentUrl());
        WebElement element = driver.findElement(By.id("text_area"));
        int beforeNum = driver.findElements(By.id("comment")).size();
        element.sendKeys("This is Selenium test!");
        element.submit();
        return driver.findElements(By.id("comment")).size() == (beforeNum + 1);
    }
}
