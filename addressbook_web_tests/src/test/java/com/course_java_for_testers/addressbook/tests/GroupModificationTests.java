package com.course_java_for_testers.addressbook.tests;

import com.course_java_for_testers.addressbook.appmanager.HelperBase;
import com.course_java_for_testers.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase {

    @Test
    public void testGroupModification() {
        app.getNavigationHelper().gotoGroupPage();

        if (!app.getGroupHelper().isGroupPresent()){
            app.getGroupHelper().createGroup(new GroupData(
                    "test1",
                    "test2",
                    "test3"));}

        int before = app.getGroupHelper().getGroupCount();
        
        app.getGroupHelper().selectGroup(before-1); // выбрали последний элемент из списка
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData(
                "test1mod",
                "test2mod",
                "test3mod"));

        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returntoGroupPage();
        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after,before,"Колличество групп после модификации группы не должно меняться");
    }
}
