package com.course_java_for_testers.addressbook.tests;

import com.course_java_for_testers.addressbook.model.GroupData;
import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().createGroup(new GroupData("test1", "test2", "test3"));
    }
}
