package com.course_java_for_testers.addressbook.tests;

import com.course_java_for_testers.addressbook.model.GroupData;
import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        app.gotoGroupPage();
        app.initGroupCreation();
        app.fillGroupForm(new GroupData("test1", "test2", "test3"));
        app.submitGroupCreation();
        app.returntoGroupPage();
    }

}
