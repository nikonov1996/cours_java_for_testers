package com.course_java_for_testers.addressbook.tests;

import com.course_java_for_testers.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        app.getNavigationHelper().gotoGroupPage();
        Set<GroupData> groupListBefore = app.getGroupHelper().getGroupSet();
        GroupData createdGroup = new GroupData()
                .withName("test1")
                .withHeader("test2")
                .withFooter("test3");
        app.getGroupHelper().createGroup(createdGroup);
        Set<GroupData> groupListAfter = app.getGroupHelper().getGroupSet();
        Assert.assertEquals(
                groupListAfter.size(),
                groupListBefore.size() + 1,
                "Количество групп после создания должно быть больше чем до создания.");

        // Сравнение элементов списков групп после создания новой группы
        createdGroup.withId(groupListAfter.stream().mapToInt((g) -> g.getId()).max().getAsInt());
        groupListBefore.add(createdGroup);

        Assert.assertEquals(
                groupListAfter,
                groupListBefore,
                "Элементы  списка (кроме созданного)не должны быть изменены после создания группы");


    }
}
