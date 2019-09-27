package com.course_java_for_testers.addressbook.tests;

import com.course_java_for_testers.addressbook.model.NewContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;

public class ContactDeletionTests extends TestBase {

    @Test(enabled = false) //TODO ИСПРАВИТЬ: при дебаге тест проходит, при запуске падает, after равно before по ококончанию
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

        int before = app.getContactHelper().getContactCount();
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectedContact();
        app.getNavigationHelper().gotoHomePage();

        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after,before-1,"После удаления кол-во контактов должно быть меньше на единицу");

    }
}
