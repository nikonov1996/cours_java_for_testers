package com.course_java_for_testers.addressbook.appmanager;

import com.course_java_for_testers.addressbook.model.ContactList;
import com.course_java_for_testers.addressbook.model.GroupData;
import com.course_java_for_testers.addressbook.model.NewContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver driver) {
        super(driver);
    }

    public void submitNewContactCreation() {
        click(By.name("submit"));
    }

    public void gotoCreateNewContact() {
        click(By.linkText("add new"));
    }

    public void returnToHomePage() {
        if (isElementPresent(By.id("maintable"))) {
            return;
        } else {
            click(By.linkText("home"));
        }
    }

    public void deleteSelectedContact() {
        click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Select all'])[1]/following::input[2]"));
        confirmDeletion();
    }


    public void deleteContact(List<NewContactData> contact) {
        int randomIndex = (int) (Math.random() * contact.size()); // рандомный контакт
        int lastIndex = contact.size() - 1; // последний контакт
        selectContact(lastIndex);
        deleteSelectedContact();
        contactCache = null;
        returnToHomePage();
        sleepScript(5000);
    }

    //выбор контакта по индексу
    public void selectContact(int index) {
        driver.findElements(By.name("selected[]")).get(index).click();
    }

    public void fillContactForm(NewContactData newContactData, boolean creation) {
        type(By.name("firstname"), newContactData.getFirstname());
        type(By.name("lastname"), newContactData.getLastname());
        type(By.name("nickname"), newContactData.getNickname());
        type(By.name("title"), newContactData.getTitle());
        type(By.name("address"), newContactData.getAddress());
        type(By.name("company"), newContactData.getCompany());
        type(By.name("home"), newContactData.getHomePhone());
        type(By.name("mobile"), newContactData.getMobilePhone());
        type(By.name("home"), newContactData.getHomePhone());
        type(By.name("email"), newContactData.getEmail());
        attach(By.name("photo"),newContactData.getPhoto());

        // Если "создание контакта", то есть выбор групп, если "модификация контакта", то выбор групп отсутствует
        if (creation) {
            new Select(driver.findElement(By.name("new_group"))).selectByVisibleText(newContactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")), "Кнопки выбора групп контактов не должно быть на странице модификации!");
        }
    }

    public void createContact(NewContactData contactdata, boolean creation) {
        fillContactForm(contactdata, creation);
        submitNewContactCreation();
        contactCache = null;
    }

    public boolean isContactPresent() {
        return isElementPresent(By.name("selected[]"));
    }

    public int getContactCount() {
        return driver.findElements(By.name("selected[]")).size();
    }


    private ContactList contactCache = null;
    public ContactList getContactList() {
        if (contactCache != null){
            return new ContactList(contactCache);
        }
        contactCache = new ContactList();
        List<WebElement> elements = driver.findElements(By.cssSelector("tr[name=\"entry\"]")); //td:nth-child(2)

        for (WebElement elem : elements) {
            String lastname = elem.findElement(By.cssSelector("td:nth-child(2)")).getText();
            String firstname = elem.findElement(By.cssSelector("td:nth-child(3)")).getText();
            String address = elem.findElement(By.cssSelector("td:nth-child(4)")).getText();
            String email = elem.findElement(By.cssSelector("td:nth-child(5)")).getText();
            contactCache.add(new NewContactData().withLastname(lastname).withFirstname(firstname).withAddress(address).withEmail(email));
        }
        return new ContactList(contactCache);
    }
}
