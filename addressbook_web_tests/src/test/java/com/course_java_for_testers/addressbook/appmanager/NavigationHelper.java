package com.course_java_for_testers.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(WebDriver driver) {
        super(driver);
    }

    public void gotoGroupPage() {
        click(By.linkText("Группы"));
    }

    public void gotoHomePage() {
        click(By.linkText("Главная"));
    }
}
