package com.course_java_for_testers.addressbook;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {
    @Test
    public void testGroupDeletion() throws Exception {
        gotoGroupPage();
        selectGroup();
        deleteSelectedGroups();
        returntoGroupPage();
    }
}
