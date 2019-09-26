package com.course_java_for_testers.addressbook.tests;

import com.course_java_for_testers.addressbook.model.NewContactData;
import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

    @Test
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
                    null), false);} // указываем, что это не создание "контакта"
        app.getNavigationHelper().gotoHomePage();
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectedContact();
        app.getNavigationHelper().gotoHomePage();
    }
}
