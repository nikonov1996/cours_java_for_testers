package com.course_java_for_testers.addressbook.tests;

import com.course_java_for_testers.addressbook.model.NewContactData;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation(){
        app.getContactHelper().gotoCreateNewContact();
        app.getContactHelper().fillNewContactForm(new NewContactData("testname", "testlastname", "testnickname", "testtitle", "testaddress", "testcompany", "808080808", "80808080808", "test@test"));
        app.getContactHelper().submitNewContactCreation();
        app.getNavigationHelper().gotoHomePage();
    }

}
