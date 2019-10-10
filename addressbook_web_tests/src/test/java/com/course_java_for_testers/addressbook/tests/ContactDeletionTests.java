package com.course_java_for_testers.addressbook.tests;

import com.course_java_for_testers.addressbook.model.ContactList;
import com.course_java_for_testers.addressbook.model.NewContactData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;

public class ContactDeletionTests extends TestBase {

    public void ensurePreconditions (){
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
    }

    @Test(enabled = true)
    public void testContactDeletion() {
        ensurePreconditions();
        ContactList contactListBefore = app.getContactHelper().getContactList();
        NewContactData deletedContact = contactListBefore.get(contactListBefore.size()-1);
        app.getContactHelper().deleteContact(contactListBefore);

        Assert.assertEquals(
                app.getContactHelper().getContactCount(),
                contactListBefore.size()-1,
                "После удаления кол-во контактов должно быть меньше на единицу");
        ContactList contactListAfter = app.getContactHelper().getContactList();

        Assert.assertEquals(
                new HashSet<>(contactListAfter),
                new HashSet<>(contactListBefore.without(deletedContact)),
                "Элементы списка контактов (кроме удаляемого) не должны изменятся после удаления группы.");
    }


}
