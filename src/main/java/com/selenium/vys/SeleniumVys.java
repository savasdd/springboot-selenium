package com.selenium.vys;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;

public class SeleniumVys extends DriverManagerVys {

    private WebElement element, element1;

    public SeleniumVys(String browser) throws MalformedURLException {
        setDriver(browser);
    }

    @Override
    public void setDriver(String browser) throws MalformedURLException {
        super.setDriver(browser);
    }

    public void vysLoginTest() throws InterruptedException {
        driver.get("https://vystest.enerji.gov.tr/account/login");
        sleep(1000);

        element = driver.findElement(By.id("email"));
        element.click();
        element.sendKeys("savas.dede@enerji.gov.tr");
        element.sendKeys(Keys.ENTER);

        sleep(1000);
        element1 = driver.findElement(By.id("password"));
        element1.click();
        element1.sendKeys("Aa123456*");
        element1.sendKeys(Keys.ENTER);
        sleep(3000);
    }

    public void sinavLoginTest() throws InterruptedException {
        driver.get("https://sinavsonuc.enerji.gov.tr/login");
        sleep(1000);

        element = driver.findElement(By.id("email"));
        element.click();
        element.sendKeys("savas.dede@enerji.gov.tr");
        element.sendKeys(Keys.ENTER);

        sleep(1000);
        element1 = driver.findElement(By.id("password"));
        element1.click();
        element1.sendKeys("*******");
        element1.sendKeys(Keys.ENTER);
        sleep(3000);
    }

    public void logout() {
        driver.quit();
    }

    private void sleep(int duration) throws InterruptedException {
        Thread.sleep(duration);
    }
}
