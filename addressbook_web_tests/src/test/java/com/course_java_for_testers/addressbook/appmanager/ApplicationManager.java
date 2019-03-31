package com.course_java_for_testers.addressbook.appmanager;

import com.course_java_for_testers.addressbook.model.GroupData;
import com.course_java_for_testers.addressbook.model.NewContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ApplicationManager {
    FirefoxDriver driver;

    public void init() {
        System.setProperty("webdriver.gecko.driver", "C:\\SeleniumGecko\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        String url = "http://localhost:8080/addressbook/group.php";
        driver.get(url);
        login("admin", "secret");
    }

    public void login(String username, String password) {
        driver.findElement(By.name("user")).click();
        driver.findElement(By.name("user")).clear();
        driver.findElement(By.name("user")).sendKeys(username);
        driver.findElement(By.name("pass")).click();
        driver.findElement(By.name("pass")).clear();
        driver.findElement(By.name("pass")).sendKeys(password);
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Password:'])[1]/following::input[2]")).click();
    }

    public void returntoGroupPage() {
        driver.findElement(By.linkText("group page")).click();
    }

    public void submitGroupCreation() {
        driver.findElement(By.name("submit")).click();
    }

    public void fillGroupForm(GroupData groupData) {
        driver.findElement(By.name("group_name")).click();
        driver.findElement(By.name("group_name")).clear();
        driver.findElement(By.name("group_name")).sendKeys(groupData.getGrname());
        driver.findElement(By.name("group_header")).click();
        driver.findElement(By.name("group_header")).clear();
        driver.findElement(By.name("group_header")).sendKeys(groupData.getGrheader());
        driver.findElement(By.name("group_footer")).click();
        driver.findElement(By.name("group_footer")).clear();
        driver.findElement(By.name("group_footer")).sendKeys(groupData.getGrfooter());
    }

    public void initGroupCreation() {
        driver.findElement(By.name("new")).click();
    }

    public void gotoGroupPage() {
        driver.findElement(By.linkText("groups")).click();
    }

    public void gotoHomePage() {
        driver.findElement(By.linkText("home page")).click();
    }

    public void submitNewContactCreation() {
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Notes:'])[1]/following::input[1]")).click();
    }

    public void fillNewContactForm(NewContactData newContactData) {
        driver.findElement(By.name("firstname")).click();
        driver.findElement(By.name("firstname")).clear();
        driver.findElement(By.name("firstname")).sendKeys(newContactData.getFirstname());
        driver.findElement(By.name("lastname")).click();
        driver.findElement(By.name("lastname")).clear();
        driver.findElement(By.name("lastname")).sendKeys(newContactData.getLastname());
        driver.findElement(By.name("nickname")).click();
        driver.findElement(By.name("nickname")).clear();
        driver.findElement(By.name("nickname")).sendKeys(newContactData.getNickname());
        driver.findElement(By.name("title")).click();
        driver.findElement(By.name("title")).clear();
        driver.findElement(By.name("title")).sendKeys(newContactData.getTitle());
        driver.findElement(By.name("address")).click();
        driver.findElement(By.name("address")).clear();
        driver.findElement(By.name("address")).sendKeys(newContactData.getAddress());
        driver.findElement(By.name("company")).click();
        driver.findElement(By.name("company")).clear();
        driver.findElement(By.name("company")).sendKeys(newContactData.getCompany());
        driver.findElement(By.name("home")).click();
        driver.findElement(By.name("home")).clear();
        driver.findElement(By.name("home")).sendKeys(newContactData.getHomePhone());
        driver.findElement(By.name("mobile")).click();
        driver.findElement(By.name("mobile")).clear();
        driver.findElement(By.name("mobile")).sendKeys(newContactData.getMobilePhone());
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys(newContactData.getEmail());
    }

    public void gotoCreateNewContact() {
        driver.findElement(By.linkText("add new")).click();
    }

    public void stop() {
        driver.quit();
    }

    public void deleteSelectedGroups() {
        driver.findElement(By.name("delete")).click();
    }

    public void selectGroup() {
        driver.findElement(By.name("selected[]")).click();
    }
}
