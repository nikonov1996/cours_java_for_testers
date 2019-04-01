package com.course_java_for_testers.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper {
    private FirefoxDriver driver;

    public NavigationHelper(FirefoxDriver driver) {
        this.driver = driver;
    }

    public void gotoGroupPage() {
        driver.findElement(By.linkText("groups")).click();
    }

    public void gotoHomePage() {
        driver.findElement(By.linkText("home page")).click();
    }

    public void gotoCreateNewContact() {
        driver.findElement(By.linkText("add new")).click();
    }
}
