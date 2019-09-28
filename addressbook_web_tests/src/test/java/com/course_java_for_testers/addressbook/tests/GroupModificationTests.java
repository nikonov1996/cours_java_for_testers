package com.course_java_for_testers.addressbook.tests;

import com.course_java_for_testers.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

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

        List<GroupData> before = app.getGroupHelper().getGroupList();
        app.getGroupHelper().selectGroup(before.size() - 1); // выбрали последний элемент из списка
        app.getGroupHelper().initGroupModification();

        GroupData modificatedGroup = new GroupData(
                "test1",
                "test2",
                "test3",
                before.get(before.size() - 1).getId());

        app.getGroupHelper().fillGroupForm(modificatedGroup);
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returntoGroupPage();
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size(), "Колличество групп после модификации группы не должно меняться");

        // сравнение элементов списка групп после модификации
        before.remove(before.size() - 1);
        before.add(modificatedGroup);
        Assert.assertEquals(new HashSet<>(after),new HashSet<>(before),"Элементы  списка (кроме модифицируемого)не должны быть изменены после модификации группы");

    }
}
