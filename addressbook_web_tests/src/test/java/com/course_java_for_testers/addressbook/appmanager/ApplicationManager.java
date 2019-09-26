package com.course_java_for_testers.addressbook.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.Objects;


public class ApplicationManager {

    WebDriver driver;
    private NavigationHelper navigationHelper;
    private GroupHelper groupHelper;
    private SessionHelper sessionHelper;
    private ContactHelper contactHelper;
    private String browser;
    /*private final String FirefoxDriverPath = "C:\\WebDrivers\\geckodriver.exe";
    private final String ChromeDriverPath = "C:\\WebDrivers\\chromedriver.exe";
    private final String IEDriverPath = "C:\\WebDrivers\\IEDriverServer.exe";*/

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init() {

        if (Objects.equals(browser, BrowserType.FIREFOX)) {
            System.setProperty("webdriver.gecko.driver", "C:\\Geckodriver\\geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (Objects.equals(browser, BrowserType.CHROME)) {
            System.setProperty("webdriver.chrome.driver", "C:\\Chromedriver\\chromedriver.exe");
            driver = new ChromeDriver();
        } else {
            driver = new InternetExplorerDriver();
        }

        driver.manage().window().maximize();
        driver.navigate().to("http://localhost:122/addressbook");
        groupHelper = new GroupHelper(driver);
        navigationHelper = new NavigationHelper(driver);
        sessionHelper = new SessionHelper(driver);
        contactHelper = new ContactHelper(driver);
        sessionHelper.login("admin", "secret");
    }

    public void stop() {
      //  driver.close();
        driver.quit();
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public ContactHelper getContactHelper() {
        return contactHelper;
    }
}
