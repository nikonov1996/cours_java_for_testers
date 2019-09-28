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
            app.getContactHelper().createContact(new NewContactData(
                    "testname",
                    "testlastname",
                    "testnickname",
                    "testtitle",
                    "testaddress",
                    "testcompany",
                    "808080808",
                    "80808080808",
                    "test@test",
                    "test1"),
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
