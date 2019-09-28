package com.course_java_for_testers.addressbook.tests;

import com.course_java_for_testers.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        app.getNavigationHelper().gotoGroupPage();
        List<GroupData> before = app.getGroupHelper().getGroupList();
        GroupData createdGroup = new GroupData("test1", "test2", "test3");
        app.getGroupHelper().createGroup(createdGroup);
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size() + 1, "Количество групп после создания должно быть больше чем до создания.");

        // Сравнение элементов списков групп после создания новой группы

        //находим максимальный id группы
        int max = 0;
        for (GroupData g : after) {
            if (g.getId() > max) {
                max = g.getId();
            }
        }

        createdGroup.setId(max);
        before.add(createdGroup);
        Assert.assertEquals(new HashSet<>(after), new HashSet<>(before), "Элементы  списка (кроме созданного)не должны быть изменены после создания группы");
    }
}
