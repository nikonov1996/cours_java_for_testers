package com.course_java_for_testers.addressbook.tests;

import com.course_java_for_testers.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class GroupModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.getNavigationHelper().gotoGroupPage();
        if (!app.getGroupHelper().isGroupPresent()) {
            app.getGroupHelper().createGroup(new GroupData(
                    "test1",
                    "test2",
                    "test3"));
        }
    }

    @Test
    public void testGroupModification() {
        List<GroupData> groupListBefore = app.getGroupHelper().getGroupList();
        int index = groupListBefore.size() - 1;
        GroupData modificatedGroup = new GroupData(
                "test1",
                "test2",
                "test3",
                groupListBefore.get(index).getId());
        app.getGroupHelper().modifyGroup(modificatedGroup,index);
        List<GroupData> groupListAfter = app.getGroupHelper().getGroupList();
        Assert.assertEquals(groupListAfter.size(), groupListBefore.size(), "Колличество групп после модификации группы не должно меняться");

        // сравнение элементов списка групп после модификации
        groupListBefore.remove(index);
        groupListBefore.add(modificatedGroup);

        Comparator<? super GroupData> byId =(g1, g2)-> Integer.compare(g1.getId(),g2.getId());
        groupListBefore.sort(byId);
        groupListAfter.sort(byId);
        Assert.assertEquals(groupListAfter,groupListBefore,"Элементы  списка (кроме модифицируемого)не должны быть изменены после модификации группы");

    }

}
