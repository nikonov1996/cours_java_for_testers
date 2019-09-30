package com.course_java_for_testers.addressbook.tests;

import com.course_java_for_testers.addressbook.model.NewContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.NoSuchElementException;

public class ContactDeletionTests extends TestBase {

    @Test(enabled = true)
    public void testContactDeletion() {
        app.getNavigationHelper().gotoHomePage();

        if (!app.getContactHelper().isContactPresent()){
            app.getContactHelper().gotoCreateNewContact();
            app.getContactHelper().createContact(new NewContactData()
                            .withFirstname("testname")
                            .withLastname("testlastname")
                            .withNickname("testnickname")
                            .withTitle("testtitle")
                            .withAddress("testaddress")
                            .withCompany("testcompany")
                            .withHomePhone("54872")
                            .withMobilePhone("89135876592")
                            .withEmail("test@test")
                            .withGroup("test1"),
                    true);// указываем, что это создание "контакта"
            app.getNavigationHelper().gotoHomePage();}

        List<NewContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(before.size()-1);
        app.getContactHelper().deleteSelectedContact();
        app.getNavigationHelper().gotoHomePage();
        app.sleepScript(5000);
        List<NewContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(),before.size()-1,"После удаления кол-во контактов должно быть меньше на единицу");

    }
}
