package com.course_java_for_testers.addressbook.tests;

import com.course_java_for_testers.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class GroupModificationTests extends TestBase {

    @Test
    public void testGroupModification() {
        app.getNavigationHelper().gotoGroupPage();

        if (!app.getGroupHelper().isGroupPresent()) {
            app.getGroupHelper().createGroup(new GroupData(
                    "test1",
                    "test2",
                    "test3"));
        }

        List<GroupData> groupListBefore = app.getGroupHelper().getGroupList();
        app.getGroupHelper().selectGroup(groupListBefore.size() - 1); // выбрали последний элемент из списка
        app.getGroupHelper().initGroupModification();

        GroupData modificatedGroup = new GroupData(
                "test1",
                "test2",
                "test3",
                groupListBefore.get(groupListBefore.size() - 1).getId());

        app.getGroupHelper().fillGroupForm(modificatedGroup);
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returntoGroupPage();
        List<GroupData> groupListAfter = app.getGroupHelper().getGroupList();
        Assert.assertEquals(groupListAfter.size(), groupListBefore.size(), "Колличество групп после модификации группы не должно меняться");

        // сравнение элементов списка групп после модификации
        groupListBefore.remove(groupListBefore.size() - 1);
        groupListBefore.add(modificatedGroup);

        Comparator<? super GroupData> byId =(g1, g2)-> Integer.compare(g1.getId(),g2.getId());
        groupListBefore.sort(byId);
        groupListAfter.sort(byId);
        Assert.assertEquals(groupListAfter,groupListBefore,"Элементы  списка (кроме модифицируемого)не должны быть изменены после модификации группы");

    }
}
