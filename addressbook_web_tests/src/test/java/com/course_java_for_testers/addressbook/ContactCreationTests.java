package com.course_java_for_testers.addressbook;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation(){
        gotoCreateNewContact();
        fillNewContactForm(new NewContactData("testname", "testlastname", "testnickname", "testtitle", "testaddress", "testcompany", "808080808", "80808080808", "test@test"));
        submitNewContactCreation();
        gotoHomePage();
    }

}
