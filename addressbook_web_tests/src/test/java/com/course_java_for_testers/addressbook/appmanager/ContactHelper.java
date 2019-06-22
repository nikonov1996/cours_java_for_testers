package com.course_java_for_testers.addressbook.appmanager;

import com.course_java_for_testers.addressbook.model.NewContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver driver){
        super(driver);
    }

    public void submitNewContactCreation() {
        click(By.name("submit"));
    }

    public void gotoCreateNewContact() {
        click(By.linkText("add new"));
    }

    public void deleteSelectedContact() {
        click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Select all'])[1]/following::input[2]"));
        confirmDeletion();
    }

    public void selectContact() {
        click(By.name("selected[]"));
    }

    public void fillNewContactForm(NewContactData newContactData) {
        type(By.name("firstname"),newContactData.getFirstname());
        type(By.name("lastname"),newContactData.getLastname());
        type(By.name("nickname"),newContactData.getNickname());
        type(By.name("title"),newContactData.getTitle());
        type(By.name("address"),newContactData.getAddress());
        type(By.name("company"),newContactData.getCompany());
        type(By.name("home"),newContactData.getHomePhone());
        type(By.name("mobile"),newContactData.getMobilePhone());
        type(By.name("home"),newContactData.getHomePhone());
        type(By.name("email"),newContactData.getEmail());
    }
}
