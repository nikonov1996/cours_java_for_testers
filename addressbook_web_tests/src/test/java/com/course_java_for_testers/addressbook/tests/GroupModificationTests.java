package com.course_java_for_testers.addressbook.tests;

import com.course_java_for_testers.addressbook.model.GroupData;
import com.course_java_for_testers.addressbook.model.GroupsSet;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GroupModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.getNavigationHelper().gotoGroupPage();
        if (!app.getGroupHelper().isGroupPresent()) {
            app.getGroupHelper().createGroup(new GroupData()
                    .withName("test1")
                    .withHeader("test2")
                    .withFooter("test3"));
        }
    }

    @Test
    public void testGroupModification() {
        GroupsSet groupListBefore = app.getGroupHelper().getGroupSet();
        GroupData groupBeforeModify = groupListBefore.iterator().next();
        GroupData groupAfterModify = new GroupData()
                .withId(groupBeforeModify.getId())
                .withName("test1")
                .withHeader("test2")
                .withFooter("test3");

        app.getGroupHelper().modifyGroup(groupAfterModify);

        Assert.assertEquals(
                app.getGroupHelper().getGroupCount(),
                groupListBefore.size(),
                "Колличество групп после модификации группы не должно меняться");
        GroupsSet groupListAfter = app.getGroupHelper().getGroupSet();

        // сравнение элементов списка групп после модификации
        Assert.assertEquals(
                groupListAfter,
                groupListBefore
                .without(groupAfterModify) // поломка
                .withAdded(groupAfterModify),
                "Элементы  списка (кроме модифицируемого)не должны быть изменены после модификации группы");

    }

}
