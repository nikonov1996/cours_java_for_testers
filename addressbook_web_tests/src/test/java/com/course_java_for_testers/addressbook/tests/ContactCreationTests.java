package com.course_java_for_testers.addressbook.tests;

import com.course_java_for_testers.addressbook.model.NewContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation(){
        app.getNavigationHelper().gotoHomePage();
        List<NewContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().gotoCreateNewContact();
        NewContactData createdContact = new NewContactData()
                .withFirstname("testname")
                .withLastname("testlastname")
                .withNickname("testnickname")
                .withTitle("testtitle")
                .withAddress("testaddress")
                .withCompany("testcompany")
                .withHomePhone("54872")
                .withMobilePhone("89135876592")
                .withEmail("test@test")
                .withGroup("test1");
        app.getContactHelper().createContact(createdContact,true); // подтверждение что контакт создается, а не модифицируется
        app.getNavigationHelper().gotoHomePage();
        List<NewContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size()+1,"При создании контакта, количество контактов в таблице должно увеличиваться на единицу");

        before.add(createdContact);
        Assert.assertEquals(new HashSet<>(after),new HashSet<>(before));
    }

}
