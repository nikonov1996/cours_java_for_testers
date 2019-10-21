package com.course_java_for_testers.addressbook.tests;

import com.course_java_for_testers.addressbook.appmanager.ApplicationManager;
import com.course_java_for_testers.addressbook.model.TestDataProvider;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class TestBase extends TestDataProvider {

    Logger logger = LoggerFactory.getLogger(TestBase.class);

    protected static final ApplicationManager app = new ApplicationManager(System.getProperty("browser",BrowserType.CHROME));

    @BeforeSuite
    public void setUp() throws IOException {
        app.init();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown(){
        app.stop();
    }

    @BeforeMethod(alwaysRun = true)
    public void logTestStart(Method currentMethod, Object[] parametrs){
        logger.info("Test '" + currentMethod.getName() + "' started..");
        logger.info("Test's params: " + Arrays.asList(parametrs));
    }

    @AfterMethod(alwaysRun = true)
    public void logTestStop(Method currentMethod){
        logger.info("Test '" + currentMethod.getName() + "' stopped");
    }
}
