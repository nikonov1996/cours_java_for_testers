package com.course_java_for_testers.addressbook.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.testng.ReporterConfig;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class ApplicationManager {

    private final Properties properties;
    WebDriver driver;
    private NavigationHelper navigationHelper;
    private GroupHelper groupHelper;
    private SessionHelper sessionHelper;
    private ContactHelper contactHelper;
    private String browser;


    public ApplicationManager(String browser) {
        this.browser = browser;
        properties = new Properties();
    }

    public void init() throws IOException {

        String target = System.getProperty("target","local");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties",target))));

        if (Objects.equals(browser, BrowserType.FIREFOX)) {
            System.setProperty("webdriver.gecko.driver", "C:\\Geckodriver\\geckodriver.exe");
            driver = new FirefoxDriver();
            //driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        } else if (Objects.equals(browser, BrowserType.CHROME)) {
            System.setProperty("webdriver.chrome.driver", "C:\\Chromedriver\\chromedriver.exe");
             //toDo как решить проблему веб-драйверов: прописывать в переменных средах не работает, добавлять в директорию проекта дурной тон,а прописывать явно как то стремно
            driver = new ChromeDriver();
        } else {
            driver = new InternetExplorerDriver();
        }

        driver.manage().window().maximize();
        driver.navigate().to(
                properties.getProperty("web.baseURL"));
        groupHelper = new GroupHelper(driver);
        navigationHelper = new NavigationHelper(driver);
        sessionHelper = new SessionHelper(driver);
        contactHelper = new ContactHelper(driver);
        sessionHelper.login(
                properties.getProperty("web.adminLogin"),
                properties.getProperty("web.adminPassword"));
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
