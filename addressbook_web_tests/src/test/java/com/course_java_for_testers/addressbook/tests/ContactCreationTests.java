package com.course_java_for_testers.addressbook.tests;

import com.course_java_for_testers.addressbook.model.NewContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation(){
        app.getNavigationHelper().gotoHomePage();
        List<NewContactData> before = app.getContactHelper().getContactList();
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
                true); // подтверждение что контакт создается, а не модифицируется
        app.getNavigationHelper().gotoHomePage();
        List<NewContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size()+1,"При создании контакта, количество контактов в таблице должно увеличиваться на единицу");
    }

}
