package com.course_java_for_testers.addressbook.tests;

import com.course_java_for_testers.addressbook.model.NewContactData;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation(){
        app.getNavigationHelper().gotoCreateNewContact();
        app.fillNewContactForm(new NewContactData("testname", "testlastname", "testnickname", "testtitle", "testaddress", "testcompany", "808080808", "80808080808", "test@test"));
        app.submitNewContactCreation();
        app.getNavigationHelper().gotoHomePage();
    }

}
