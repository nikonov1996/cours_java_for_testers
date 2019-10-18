package com.course_java_for_testers.addressbook.tests;

import com.course_java_for_testers.addressbook.appmanager.ApplicationManager;
import com.course_java_for_testers.addressbook.model.TestDataProvider;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public class TestBase extends TestDataProvider {

    protected static final ApplicationManager app = new ApplicationManager(System.getProperty("browser",BrowserType.CHROME));

    @BeforeSuite
    public void setUp() throws IOException {
        app.init();
    }

    @AfterSuite
    public void tearDown(){
        app.stop();
    }
}
